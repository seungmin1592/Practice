package com.security.demo.Controller;

import com.security.demo.model.User;
import com.security.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"", "/"})
    public String index(){
        // 머스테치 기본폴더 src/main/resources/
        // viewresolver 설정 : templates (prefix), mustache (suffix)
        // mustache을 의존성 주입하면 자동으로 설정된다
        return "index"; // src/main/resources/templates/index.mustache
    }

    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }

    // 스프링 시큐리티가 해당 주소를 낚아챔
    @GetMapping("/loginForm")
    public String login(){
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(User user){
        System.out.println(user);
        user.setRole("ROLE_USER");
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);

        userRepository.save(user); // 회원가입 => 비밀번호 암호화 x => 시큐리티로 로그인 x 패스워드 암호화가 안되어있기 때문
        return "redirect:/loginForm";
    }

    @Secured("ROLE_ADMIN") // ADMIN 권한만 접근 가능
    @GetMapping("/info")
    public @ResponseBody String info(){
        return "개인정보";
    }

    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')") // 권한을 여러개 주고 싶을 경우
    @GetMapping("/data")
    public @ResponseBody String data(){
        return "데이터정보";
    }

}

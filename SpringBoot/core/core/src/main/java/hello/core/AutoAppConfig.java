package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 수동 Bean과 자동 Bean을 같이 등록시엔 수동Bean이 자동 Bean을 오버라이딩하지만, Spring Boot를 실행시에 오류가 난다
    // spring.main.allow-bean-definition-overriding=true  // properties에 false가 Default 값으로 되어있음. true로 설정시엔 오류을 발생시키지 않고 오버라이딩한다
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}

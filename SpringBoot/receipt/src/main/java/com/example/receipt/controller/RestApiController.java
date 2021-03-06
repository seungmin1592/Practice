package com.example.receipt.controller;


import com.example.receipt.jwt.JwtTokenProvider;
import com.example.receipt.model.Receipt;
import com.example.receipt.repository.ReceiptRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/api/v1")
public class RestApiController {
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping({"/createToken"})
    @ApiOperation(
            value = "createToken",
            notes = "토큰 생성"
    )
    public ResponseEntity<Map<String, Object>> createToken(@RequestParam String companyno, @RequestParam String companyname, HttpServletResponse res) throws Exception {
        System.out.println("findUserName = " + this.receiptRepository.findByCompanyno(companyno));
        Map<String, Object> rMap = new HashMap();
        if (this.receiptRepository.findByCompanynoAndCompanyname(companyno, companyname) == null) {
            return ResponseEntity.notFound().build();
        } else {
            String token = this.jwtTokenProvider.createToken(companyno, companyname);
            rMap.put("msg", "토큰 발급 성공");
            rMap.put("status", HttpStatus.OK);
            rMap.put("token", token);

            res.addHeader("Authorization", "Bearer " + token);
        }
        return new ResponseEntity(rMap, HttpStatus.OK);
    }

    @GetMapping("/setReceipt")
    @ApiImplicitParams({@ApiImplicitParam(
            name = "X-AUTH-TOKEN",
            value = "로그인 성공 후 access_token",
            required = true,
            dataType = "String",
            paramType = "header"
    )})
    public ResponseEntity<Receipt> setReceipt(@RequestParam Map<String, Object> pMap, HttpServletRequest req) {
        String token = req.getHeader("X-AUTH-TOKEN");
        pMap.put("title", "test");
        System.out.println("pMap === " + pMap);

        Map<String, Object> payload = new HashMap();

        try {
            payload = this.jwtTokenProvider.decryptToken(token);
        } catch (JsonProcessingException var6) {
            var6.printStackTrace();
        }

        System.out.println("payload = " + payload);

        System.out.println("parsing : " + (String)((Map)payload).get("companyno") + "/////" + (String) payload.get("companyname"));

        Receipt result = this.receiptRepository.findByCompanyno((String) payload.get("companyno"));

        System.out.println("result = " + result);
        if (result == null) {

            System.out.println("실패");
        } else {
            System.out.println("성공");
            System.out.println("DB에 데이터 저장");

        }

        return new ResponseEntity(pMap, HttpStatus.OK);
    }
}

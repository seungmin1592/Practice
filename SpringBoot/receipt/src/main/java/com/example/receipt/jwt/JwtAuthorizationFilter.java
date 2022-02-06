package com.example.receipt.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.receipt.model.Receipt;
import com.example.receipt.repository.ReceiptRepository;


import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 시큐리티가 filter를 가지고 있는데 그 필터중에 BasicAuthenticationFilter 라는 것이 있음
// 권한이나 인증이 필요한 특정 주소를 요청했을 떄 위 필터를 무조건 타게 되어있음.
// 만약에 권한이 인증이 필요한 주소가 아니라면 이 필터를 안탐
public class JwtAuthorizationFilter extends HttpFilter {
    
    private ReceiptRepository receiptRepository;

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("인증이나 권한이 필요한 주소 요청이 됨");

        String jwtHeader = request.getHeader("Authorization");
        System.out.println("jwtHeader : " + jwtHeader);


        // header가 있는지, Token이 Bearer로 시작하는지 검증
        if(jwtHeader == null || !jwtHeader.startsWith("Bearer")){
            chain.doFilter(request,response);
            return;
        }

        // JWT 토큰을 검증을 해서 정상적인 사용자인지 확인
        String jwtToken = request.getHeader("Authorization").replace("Bearer ", ""); // (Bearer )를 잘라줌
        String companyno = JWT.require(Algorithm.HMAC512("secretkey")).build().verify(jwtToken).getClaim("companyno").asString();

        // 서명이 정상적으로 됨
        if(companyno != null){
            Receipt userEntity = receiptRepository.findByCompanyno(companyno);

            chain.doFilter(request,response);
        }
    }

}

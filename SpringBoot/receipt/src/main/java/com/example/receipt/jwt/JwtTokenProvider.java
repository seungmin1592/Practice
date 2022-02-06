package com.example.receipt.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.receipt.util.Aes256Util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.Base64.Decoder;
import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String secretKey;
    private long tokenValidMilisecond = 6000000L;

    @PostConstruct
    protected void init() {
        this.secretKey = Base64.getEncoder().encodeToString(this.secretKey.getBytes());
    }

    public String createToken(String companyno, String companyname) throws Exception {
        Claims claims = Jwts.claims().setIssuer(companyname);
        Aes256Util a256 = Aes256Util.getInstance();
        String encryptClaims = Aes256Util.AES_Encode(companyno);
        claims.put("companyno", encryptClaims);
        Date now = new Date();

        return Jwts.builder().setHeaderParam("typ", "JWT").setClaims(claims).setIssuedAt(now).setExpiration(new Date(now.getTime() + this.tokenValidMilisecond)).signWith(SignatureAlgorithm.HS256, this.secretKey.getBytes()).compact();
    }

    public Map<String, Object> decryptToken(String token) throws JsonProcessingException {
        String[] check = token.split("\\.");
        Decoder decoder = Base64.getDecoder();
        String payload = new String(decoder.decode(check[1]));
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> returnMap = (Map)mapper.readValue(payload, Map.class);
        String companyno = (String)returnMap.get("companyno");
        Aes256Util a256 = null;

        try {
            a256 = Aes256Util.getInstance();
            returnMap.put("companyno", Aes256Util.AES_Decode(companyno));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException | InvalidKeyException var10) {
            var10.printStackTrace();
        }

        System.out.println("returnMap = " + returnMap);
        return returnMap;
    }

    // interceptor에서 토큰 유효성을 검증하기 위한 메서드
    public void checkValid(String token) {
        System.out.println("checkValid ===" + Jwts.parser().setSigningKey(this.secretKey.getBytes()).parseClaimsJws(token));
        Jwts.parser().setSigningKey(this.secretKey.getBytes()).parseClaimsJws(token);
    }

}
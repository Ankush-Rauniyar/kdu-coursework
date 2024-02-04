package com.project.smarthome.utils;

import com.project.smarthome.config.CustomAuthenticationManager;
import com.project.smarthome.dto.request.UserRegisterRequestDto;
import com.project.smarthome.filters.TokenGeneratorFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class JWTUtil {
    private final CustomAuthenticationManager customAuthProvider;
    private final TokenGeneratorFilter tokenGeneratorFilter;

    @Autowired
    public JWTUtil(CustomAuthenticationManager customAuthProvider,
                   TokenGeneratorFilter tokenGeneratorFilter) {
        this.customAuthProvider = customAuthProvider;
        this.tokenGeneratorFilter = tokenGeneratorFilter;
    }

    public String getTokenNew(UserRegisterRequestDto userRequestDTO){
        Authentication authentication = customAuthProvider.authenticate(
                new UsernamePasswordAuthenticationToken(userRequestDTO.getUsername(), userRequestDTO.getPassword())
        );
        return tokenGeneratorFilter.generateJWT(authentication);
    }

    public String decodeToken(String token){
        String secretKey = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";

        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return String.valueOf(claims.get("username"));
    }
}
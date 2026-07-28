package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    private static final SecretKey SECRET_KEY =
            Keys.hmacShaKeyFor(
                    "secretkeysecretkeysecretkey123456".getBytes(StandardCharsets.UTF_8));

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START");

        LOGGER.debug("Authorization Header : {}", authHeader);

        String user = getUser(authHeader);

        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();

        map.put("token", token);

        LOGGER.info("END");

        return map;
    }

    private String getUser(String authHeader) {

        String encodedCredentials = authHeader.substring(6);

        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String credentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        LOGGER.debug("Decoded Credentials : {}", credentials);

        return credentials.split(":")[0];
    }

    private String generateJwt(String user) {

        Date now = new Date();

        Date expiry = new Date(now.getTime() + 1200000);

        return Jwts.builder()
                .setSubject(user)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }
}
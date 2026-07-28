package com.cognizant.springlearn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    private static final SecretKey SECRET_KEY =
            Keys.hmacShaKeyFor(
                    "secretkeysecretkeysecretkey123456".getBytes(StandardCharsets.UTF_8));

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        LOGGER.info("START");

        String header = request.getHeader("Authorization");

        LOGGER.debug("Authorization Header : {}", header);

        if (header != null && header.startsWith("Bearer ")) {

            try {

                String token = header.substring(7);

                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(SECRET_KEY)
                        .build()
                        .parseClaimsJws(token)
                        .getBody();

                String user = claims.getSubject();

                LOGGER.debug("Authenticated User : {}", user);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                user,
                                null,
                                Collections.emptyList());

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);

            } catch (Exception e) {

                LOGGER.error("Invalid JWT Token");

            }
        }

        LOGGER.info("END");

        filterChain.doFilter(request, response);
    }
}
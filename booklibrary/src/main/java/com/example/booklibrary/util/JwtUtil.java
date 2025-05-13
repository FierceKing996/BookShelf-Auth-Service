package com.example.booklibrary.util;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
@Component
public class JwtUtil {

        private final Key secret = Keys.hmacShaKeyFor("your-512-bit-secret-your-512-bit-secret-".getBytes());
        private final long expirationMs = 3600_000; // 1 hour

        public String generateToken(String username) {
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                    .signWith(secret)
                    .compact();
        }

        public String extractUsername(String token) {
            return Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        }

        public boolean isTokenValid(String token, String username) {
            try {
                return username.equals(extractUsername(token));
            } catch (JwtException e) {
                return false;
            }
        }
}

package com.zosh.trading.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.security.PublicKey;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JwtProvider {

    private static final SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRETE_KEY.getBytes());

    public static String generateToken(Authentication auth) {

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        String roles = populateAuthorities(authorities);

        Date expirationDate = new Date(new Date().getTime() + 86400000);

        return Jwts.builder()
                .issuedAt(new Date()).expiration(expirationDate)
                .claim("email", auth.getName())
                .claim("authorities", roles)
                .signWith(key).compact();
    }

    public static String getEmailFromToken(String token) {
        token = token.substring(7);

        Claims claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();// 1:47:27

        return String.valueOf(claims.get("email"));

    }

    private static String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {

        Set<String> auth = new HashSet<>();
        for (GrantedAuthority ga : authorities) {
            auth.add(ga.getAuthority());
        }

        return String.join(",", auth);

    }
}

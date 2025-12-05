package com.as.astraScriptum.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private long expirationMs;

	public String generateToken(String userId) {

		return Jwts.builder().setSubject(userId) // payload principal
				.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + expirationMs))
				.signWith(SignatureAlgorithm.HS256, secret) // alg + clé
				.compact();
	}

	public String extractUserId(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validate(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
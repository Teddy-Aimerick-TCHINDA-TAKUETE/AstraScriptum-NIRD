package com.as.astraScriptum.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private final Key key;

	@Value("${jwt.expiration}")
	private long expirationMs;

	public JwtUtil(@Value("${jwt.secret}") String secret) {
		// On décode la clé en base16 (hex) ou base64 selon ton choix.
		// Ici j'ai mis une clé hexadécimale simple, donc :
		byte[] keyBytes = secret.getBytes(); // pour une simple string
		// Si tu mettais une clé en Base64, tu ferais : Decoders.BASE64.decode(secret);

		this.key = Keys.hmacShaKeyFor(keyBytes);
	}

	public String generateToken(String userId) {
		return Jwts.builder().setSubject(userId).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expirationMs))
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}

	public String extractUserId(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validate(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}
}

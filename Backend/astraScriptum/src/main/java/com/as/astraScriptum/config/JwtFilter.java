package com.as.astraScriptum.config;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.as.astraScriptum.security.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	// Endpoints qui NE DOIVENT PAS être filtrés (Swagger, login, etc.)
	private static final List<String> WHITELIST = List.of("/api/auth/login", "/v3/api-docs", "/v3/api-docs/",
			"/v3/api-docs/swagger-config", "/swagger-ui", "/swagger-ui/", "/swagger-ui/index.html");

	public JwtFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		String path = request.getServletPath();
		return WHITELIST.stream().anyMatch(path::startsWith);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		String header = request.getHeader("Authorization");

		if (header != null && header.startsWith("Bearer ")) {

			String token = header.substring(7);

			if (jwtUtil.validate(token)) {

				String userId = jwtUtil.extractUserId(token);

				var auth = new UsernamePasswordAuthenticationToken(userId, null, null);

				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}

		filterChain.doFilter(request, response);
	}
}

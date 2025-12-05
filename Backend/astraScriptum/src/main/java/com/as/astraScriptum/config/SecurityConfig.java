package com.as.astraScriptum.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.as.astraScriptum.security.JwtUtil;

@Configuration
public class SecurityConfig {

	private final JwtUtil jwtUtil;

	public SecurityConfig(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // pour simplifier en dev
				.cors(cors -> {
				}) // <── ajouter ça
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth
						// Swagger & OpenAPI en libre accès
						.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
						// Le reste : accès libre (tu peux mettre authenticated() si tu veux sécuriser)
						.anyRequest().permitAll())
				.httpBasic(Customizer.withDefaults()); // auth basique

		// pas de basic auth
		http.httpBasic(Customizer.withDefaults());

		// Ajouter filtre JWT (custom)
		http.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();

		// 🔸 URL du front autorisé
		config.setAllowedOrigins(List.of("https://astrascriptum-nird.vercel.app"));

//		config.setAllowedOrigins(List.of("http://localhost:5173", "https://astrascriptum-nird.vercel.app"));

		// 🔸 Méthodes HTTP autorisées
		config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

		// 🔸 Headers autorisés
		config.setAllowedHeaders(List.of("Authorization", "Content-Type"));

		// 🔸 Si tu envoies le JWT dans le header + cookies éventuels
		config.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}

	@Bean
	public JwtFilter jwtFilter() {
		return new JwtFilter(jwtUtil);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

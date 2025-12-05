package com.as.astraScriptum.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.astraScriptum.dto.JwtResponseDTO;
import com.as.astraScriptum.dto.LoginDTO;
import com.as.astraScriptum.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	// POST /api/auth/login
	@PostMapping("/login")
	public ResponseEntity<JwtResponseDTO> login(@Valid @RequestBody LoginDTO dto) {
		return ResponseEntity.ok(authService.login(dto));
	}
}

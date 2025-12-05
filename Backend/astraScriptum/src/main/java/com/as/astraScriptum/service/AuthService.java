package com.as.astraScriptum.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.as.astraScriptum.dto.JwtResponseDTO;
import com.as.astraScriptum.dto.LoginDTO;
import com.as.astraScriptum.model.Utilisateur;
import com.as.astraScriptum.repository.UtilisateurRepository;
import com.as.astraScriptum.security.JwtUtil;

@Service
public class AuthService {

	private final UtilisateurRepository utilisateurRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	public AuthService(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		this.utilisateurRepository = utilisateurRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}

	public JwtResponseDTO login(LoginDTO dto) {
		Utilisateur utilisateur = utilisateurRepository.findByMail(dto.getMail())
				.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

		if (!passwordEncoder.matches(dto.getPassword(), utilisateur.getPassword())) {
			throw new RuntimeException("Mot de passe incorrect");
		}

		String token = jwtUtil.generateToken(utilisateur.getId());

		return JwtResponseDTO.builder().token(token).build();
	}
}

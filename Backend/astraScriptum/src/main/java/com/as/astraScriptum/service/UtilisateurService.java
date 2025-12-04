package com.as.astraScriptum.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.as.astraScriptum.dto.CreateUtilisateurDTO;
import com.as.astraScriptum.dto.UpdateUtilisateurDTO;
import com.as.astraScriptum.dto.UtilisateurDTO;
import com.as.astraScriptum.model.Utilisateur;
import com.as.astraScriptum.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;
	private final PasswordEncoder passwordEncoder;

	public UtilisateurService(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
		this.utilisateurRepository = utilisateurRepository;
		this.passwordEncoder = passwordEncoder;
	}

	// ───── CRUD de base ─────

	public List<UtilisateurDTO> findAll() {
		return utilisateurRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public UtilisateurDTO findById(String id) {
		Utilisateur utilisateur = utilisateurRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé : " + id));
		return toDTO(utilisateur);
	}

	public UtilisateurDTO create(CreateUtilisateurDTO dto) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(UUID.randomUUID().toString());
		utilisateur.setNom(dto.getNom());
		utilisateur.setMail(dto.getMail());
		utilisateur.setType(dto.getType());

		// ⚠️ ICI : encodage du password avant sauvegarde
		String encodedPassword = passwordEncoder.encode(dto.getPassword());
		utilisateur.setPassword(encodedPassword);

		Utilisateur saved = utilisateurRepository.save(utilisateur);
		return toDTO(saved);
	}

	public UtilisateurDTO update(String id, UpdateUtilisateurDTO dto) {
		Utilisateur utilisateur = utilisateurRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé : " + id));

		utilisateur.setNom(dto.getNom());
		utilisateur.setMail(dto.getMail());
		utilisateur.setType(dto.getType());
		// On ne change pas le password ici (on fera un service séparé si besoin)

		Utilisateur updated = utilisateurRepository.save(utilisateur);
		return toDTO(updated);
	}

	public void delete(String id) {
		if (!utilisateurRepository.existsById(id)) {
			throw new RuntimeException("Utilisateur non trouvé : " + id);
		}
		utilisateurRepository.deleteById(id);
	}

	// ───── Mapping privé Entité ↔ DTO ─────

	private UtilisateurDTO toDTO(Utilisateur utilisateur) {
		return UtilisateurDTO.builder().id(utilisateur.getId()).nom(utilisateur.getNom()).mail(utilisateur.getMail())
				.type(utilisateur.getType()).build();
	}
}

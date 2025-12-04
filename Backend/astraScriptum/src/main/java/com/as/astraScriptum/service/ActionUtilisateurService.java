package com.as.astraScriptum.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.as.astraScriptum.dto.ActionUtilisateurDTO;
import com.as.astraScriptum.model.ActionUtilisateur;
import com.as.astraScriptum.model.Etablissement;
import com.as.astraScriptum.model.Utilisateur;
import com.as.astraScriptum.repository.ActionUtilisateurRepository;
import com.as.astraScriptum.repository.EtablissementRepository;
import com.as.astraScriptum.repository.UtilisateurRepository;

@Service
public class ActionUtilisateurService {

	private final ActionUtilisateurRepository actionRepo;
	private final UtilisateurRepository utilisateurRepository;
	private final EtablissementRepository etablissementRepository;

	public ActionUtilisateurService(ActionUtilisateurRepository actionRepo, UtilisateurRepository utilisateurRepository,
			EtablissementRepository etablissementRepository) {
		this.actionRepo = actionRepo;
		this.utilisateurRepository = utilisateurRepository;
		this.etablissementRepository = etablissementRepository;
	}

	public List<ActionUtilisateurDTO> findAll() {
		return actionRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public ActionUtilisateurDTO create(ActionUtilisateurDTO dto) {
		Utilisateur user = utilisateurRepository.findById(dto.getUtilisateurId())
				.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé : " + dto.getUtilisateurId()));
		Etablissement eta = etablissementRepository.findById(dto.getEtablissementId())
				.orElseThrow(() -> new RuntimeException("Etablissement non trouvé : " + dto.getEtablissementId()));

		ActionUtilisateur action = ActionUtilisateur.builder().id(UUID.randomUUID().toString()).action(dto.getAction())
				.impact(dto.getImpact()).date(dto.getDate() != null ? dto.getDate() : LocalDateTime.now())
				.utilisateur(user).etablissement(eta).build();

		return toDTO(actionRepo.save(action));
	}

	private ActionUtilisateurDTO toDTO(ActionUtilisateur a) {
		return ActionUtilisateurDTO.builder().id(a.getId()).action(a.getAction()).impact(a.getImpact())
				.date(a.getDate()).utilisateurId(a.getUtilisateur() != null ? a.getUtilisateur().getId() : null)
				.etablissementId(a.getEtablissement() != null ? a.getEtablissement().getId() : null).build();
	}
}

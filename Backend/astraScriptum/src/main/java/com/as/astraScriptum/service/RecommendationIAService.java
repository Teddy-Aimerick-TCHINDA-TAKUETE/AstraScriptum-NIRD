package com.as.astraScriptum.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.as.astraScriptum.dto.RecommendationIADTO;
import com.as.astraScriptum.model.RecommendationIA;
import com.as.astraScriptum.model.Utilisateur;
import com.as.astraScriptum.repository.RecommendationIARepository;
import com.as.astraScriptum.repository.UtilisateurRepository;

@Service
public class RecommendationIAService {

	private final RecommendationIARepository recommendationIARepository;
	private final UtilisateurRepository utilisateurRepository;

	public RecommendationIAService(RecommendationIARepository recommendationIARepository,
			UtilisateurRepository utilisateurRepository) {
		this.recommendationIARepository = recommendationIARepository;
		this.utilisateurRepository = utilisateurRepository;
	}

	public List<RecommendationIADTO> findAll() {
		return recommendationIARepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public RecommendationIADTO findById(String id) {
		RecommendationIA rec = recommendationIARepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Recommandation non trouvée : " + id));
		return toDTO(rec);
	}

	public RecommendationIADTO create(RecommendationIADTO dto) {
		Utilisateur dest = utilisateurRepository.findById(dto.getDestinataireId())
				.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé : " + dto.getDestinataireId()));

		RecommendationIA rec = RecommendationIA.builder().id(UUID.randomUUID().toString())
				.typeConseil(dto.getTypeConseil()).texte(dto.getTexte()).dateCreation(LocalDateTime.now())
				.destinataire(dest).build();

		return toDTO(recommendationIARepository.save(rec));
	}

	public void delete(String id) {
		recommendationIARepository.deleteById(id);
	}

	private RecommendationIADTO toDTO(RecommendationIA rec) {
		return RecommendationIADTO.builder().id(rec.getId()).typeConseil(rec.getTypeConseil()).texte(rec.getTexte())
				.dateCreation(rec.getDateCreation())
				.destinataireId(rec.getDestinataire() != null ? rec.getDestinataire().getId() : null).build();
	}
}

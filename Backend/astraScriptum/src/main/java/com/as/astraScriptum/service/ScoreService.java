package com.as.astraScriptum.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.as.astraScriptum.dto.ScoreDTO;
import com.as.astraScriptum.model.Score;
import com.as.astraScriptum.model.Utilisateur;
import com.as.astraScriptum.repository.ScoreRepository;
import com.as.astraScriptum.repository.UtilisateurRepository;

@Service
public class ScoreService {

	private final ScoreRepository scoreRepository;
	private final UtilisateurRepository utilisateurRepository;

	public ScoreService(ScoreRepository scoreRepository, UtilisateurRepository utilisateurRepository) {
		this.scoreRepository = scoreRepository;
		this.utilisateurRepository = utilisateurRepository;
	}

	public List<ScoreDTO> findAll() {
		return scoreRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public ScoreDTO findById(String id) {
		Score score = scoreRepository.findById(id).orElseThrow(() -> new RuntimeException("Score non trouvé : " + id));
		return toDTO(score);
	}

	public ScoreDTO create(ScoreDTO dto) {
		Utilisateur utilisateur = utilisateurRepository.findById(dto.getUtilisateurId())
				.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé : " + dto.getUtilisateurId()));

		Score score = Score.builder().id(UUID.randomUUID().toString()).souvNum(dto.getSouvNum())
				.depBigTech(dto.getDepBigTech()).progressNIRD(dto.getProgressNIRD()).utilisateur(utilisateur).build();

		return toDTO(scoreRepository.save(score));
	}

	public ScoreDTO update(String id, ScoreDTO dto) {
		Score score = scoreRepository.findById(id).orElseThrow(() -> new RuntimeException("Score non trouvé : " + id));

		score.setSouvNum(dto.getSouvNum());
		score.setDepBigTech(dto.getDepBigTech());
		score.setProgressNIRD(dto.getProgressNIRD());

		if (dto.getUtilisateurId() != null) {
			Utilisateur utilisateur = utilisateurRepository.findById(dto.getUtilisateurId())
					.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé : " + dto.getUtilisateurId()));
			score.setUtilisateur(utilisateur);
		}

		return toDTO(scoreRepository.save(score));
	}

	public void delete(String id) {
		scoreRepository.deleteById(id);
	}

	private ScoreDTO toDTO(Score score) {
		return ScoreDTO.builder().id(score.getId()).souvNum(score.getSouvNum()).depBigTech(score.getDepBigTech())
				.progressNIRD(score.getProgressNIRD())
				.utilisateurId(score.getUtilisateur() != null ? score.getUtilisateur().getId() : null).build();
	}
}

package com.as.astraScriptum.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.as.astraScriptum.dto.ScenarioInteractifDTO;
import com.as.astraScriptum.model.ScenarioInteractif;
import com.as.astraScriptum.repository.ScenarioInteractifRepository;

@Service
public class ScenarioInteractifService {

	private final ScenarioInteractifRepository scenarioRepository;

	public ScenarioInteractifService(ScenarioInteractifRepository scenarioRepository) {
		this.scenarioRepository = scenarioRepository;
	}

	// Récupérer tous les scénarios
	public List<ScenarioInteractifDTO> findAll() {
		return scenarioRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	// Récupérer un scénario par id
	public ScenarioInteractifDTO findById(String id) {
		ScenarioInteractif s = scenarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Scénario interactif non trouvé : " + id));
		return toDTO(s);
	}

	// Créer un scénario
	public ScenarioInteractifDTO create(ScenarioInteractifDTO dto) {
		ScenarioInteractif s = new ScenarioInteractif();
		s.setId(UUID.randomUUID().toString());
		s.setTitre(dto.getTitre());
		s.setQuestion(dto.getQuestion());
		s.setChoixA(dto.getChoixA());
		s.setChoixB(dto.getChoixB());
		s.setChoixC(dto.getChoixC());
		s.setConsequenceA(dto.getConsequenceA());
		s.setConsequenceB(dto.getConsequenceB());
		s.setConsequenceC(dto.getConsequenceC());

		return toDTO(scenarioRepository.save(s));
	}

	// Mettre à jour un scénario
	public ScenarioInteractifDTO update(String id, ScenarioInteractifDTO dto) {
		ScenarioInteractif s = scenarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Scénario interactif non trouvé : " + id));

		s.setTitre(dto.getTitre());
		s.setQuestion(dto.getQuestion());
		s.setChoixA(dto.getChoixA());
		s.setChoixB(dto.getChoixB());
		s.setChoixC(dto.getChoixC());
		s.setConsequenceA(dto.getConsequenceA());
		s.setConsequenceB(dto.getConsequenceB());
		s.setConsequenceC(dto.getConsequenceC());

		return toDTO(scenarioRepository.save(s));
	}

	// Supprimer un scénario
	public void delete(String id) {
		if (!scenarioRepository.existsById(id)) {
			throw new RuntimeException("Scénario interactif non trouvé : " + id);
		}
		scenarioRepository.deleteById(id);
	}

	// Mapping Entité -> DTO
	private ScenarioInteractifDTO toDTO(ScenarioInteractif s) {
		return ScenarioInteractifDTO.builder().id(s.getId()).titre(s.getTitre()).question(s.getQuestion())
				.choixA(s.getChoixA()).choixB(s.getChoixB()).choixC(s.getChoixC()).consequenceA(s.getConsequenceA())
				.consequenceB(s.getConsequenceB()).consequenceC(s.getConsequenceC()).build();
	}
}

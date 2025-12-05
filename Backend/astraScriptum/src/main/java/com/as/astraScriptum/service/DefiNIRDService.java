package com.as.astraScriptum.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.as.astraScriptum.dto.DefiNIRDDTO;
import com.as.astraScriptum.model.DefiNIRD;
import com.as.astraScriptum.model.ScenarioInteractif;
import com.as.astraScriptum.repository.DefiNIRDRepository;
import com.as.astraScriptum.repository.ScenarioInteractifRepository;

@Service
public class DefiNIRDService {

	private final DefiNIRDRepository defiRepository;
	private final ScenarioInteractifRepository scenarioRepository;

	public DefiNIRDService(DefiNIRDRepository defiRepository, ScenarioInteractifRepository scenarioRepository) {
		this.defiRepository = defiRepository;
		this.scenarioRepository = scenarioRepository;
	}

	// Récupérer tous les défis
	public List<DefiNIRDDTO> findAll() {
		return defiRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	// Récupérer un défi par id
	public DefiNIRDDTO findById(String id) {
		DefiNIRD defi = defiRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Défi NIRD non trouvé : " + id));
		return toDTO(defi);
	}

	// Créer un défi
	public DefiNIRDDTO create(DefiNIRDDTO dto) {
		ScenarioInteractif scenario = scenarioRepository.findById(dto.getScenarioId())
				.orElseThrow(() -> new RuntimeException("Scénario interactif non trouvé : " + dto.getScenarioId()));

		DefiNIRD defi = new DefiNIRD();
		defi.setId(UUID.randomUUID().toString());
		defi.setTitre(dto.getTitre());
		defi.setDescription(dto.getDescription());
		defi.setPoints(dto.getPoints());
		defi.setScenario(scenario);

		return toDTO(defiRepository.save(defi));
	}

	// Mettre à jour un défi
	public DefiNIRDDTO update(String id, DefiNIRDDTO dto) {
		DefiNIRD defi = defiRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Défi NIRD non trouvé : " + id));

		defi.setTitre(dto.getTitre());
		defi.setDescription(dto.getDescription());
		defi.setPoints(dto.getPoints());

		if (dto.getScenarioId() != null) {
			ScenarioInteractif scenario = scenarioRepository.findById(dto.getScenarioId())
					.orElseThrow(() -> new RuntimeException("Scénario interactif non trouvé : " + dto.getScenarioId()));
			defi.setScenario(scenario);
		}

		return toDTO(defiRepository.save(defi));
	}

	// Supprimer un défi
	public void delete(String id) {
		if (!defiRepository.existsById(id)) {
			throw new RuntimeException("Défi NIRD non trouvé : " + id);
		}
		defiRepository.deleteById(id);
	}

	// Mapping Entité -> DTO
	private DefiNIRDDTO toDTO(DefiNIRD d) {
		return DefiNIRDDTO.builder().id(d.getId()).titre(d.getTitre()).description(d.getDescription())
				.points(d.getPoints()).scenarioId(d.getScenario() != null ? d.getScenario().getId() : null).build();
	}
}

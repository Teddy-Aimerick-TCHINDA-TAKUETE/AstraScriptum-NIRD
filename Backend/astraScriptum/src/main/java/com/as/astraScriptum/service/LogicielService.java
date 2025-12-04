package com.as.astraScriptum.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.as.astraScriptum.dto.LogicielDTO;
import com.as.astraScriptum.model.Logiciel;
import com.as.astraScriptum.repository.LogicielRepository;

@Service
public class LogicielService {

	private final LogicielRepository logicielRepository;

	public LogicielService(LogicielRepository logicielRepository) {
		this.logicielRepository = logicielRepository;
	}

	// Récupérer tous les logiciels
	public List<LogicielDTO> findAll() {
		return logicielRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	// Récupérer un logiciel par id
	public LogicielDTO findById(String id) {
		Logiciel logiciel = logicielRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Logiciel non trouvé : " + id));
		return toDTO(logiciel);
	}

	// Créer un logiciel
	public LogicielDTO create(LogicielDTO dto) {
		Logiciel logiciel = new Logiciel();
		logiciel.setId(UUID.randomUUID().toString());
		logiciel.setNom(dto.getNom());
		logiciel.setCategorie(dto.getCategorie());
		logiciel.setLibre(dto.isLibre());
		logiciel.setProprietaire(dto.isProprietaire());

		return toDTO(logicielRepository.save(logiciel));
	}

	// Mettre à jour un logiciel
	public LogicielDTO update(String id, LogicielDTO dto) {
		Logiciel logiciel = logicielRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Logiciel non trouvé : " + id));

		logiciel.setNom(dto.getNom());
		logiciel.setCategorie(dto.getCategorie());
		logiciel.setLibre(dto.isLibre());
		logiciel.setProprietaire(dto.isProprietaire());

		return toDTO(logicielRepository.save(logiciel));
	}

	// Supprimer un logiciel
	public void delete(String id) {
		if (!logicielRepository.existsById(id)) {
			throw new RuntimeException("Logiciel non trouvé : " + id);
		}
		logicielRepository.deleteById(id);
	}

	// Mapping Entité -> DTO
	private LogicielDTO toDTO(Logiciel l) {
		return LogicielDTO.builder().id(l.getId()).nom(l.getNom()).categorie(l.getCategorie()).libre(l.isLibre())
				.proprietaire(l.isProprietaire()).build();
	}
}

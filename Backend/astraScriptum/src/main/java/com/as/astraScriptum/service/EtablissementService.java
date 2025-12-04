package com.as.astraScriptum.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.as.astraScriptum.dto.EtablissementDTO;
import com.as.astraScriptum.model.Etablissement;
import com.as.astraScriptum.model.ParcInformatique;
import com.as.astraScriptum.repository.EtablissementRepository;
import com.as.astraScriptum.repository.ParcInformatiqueRepository;

@Service
public class EtablissementService {

	private final EtablissementRepository etablissementRepository;
	private final ParcInformatiqueRepository parcRepository;

	public EtablissementService(EtablissementRepository etablissementRepository,
			ParcInformatiqueRepository parcRepository) {
		this.etablissementRepository = etablissementRepository;
		this.parcRepository = parcRepository;
	}

	public List<EtablissementDTO> findAll() {
		return etablissementRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	public EtablissementDTO create(EtablissementDTO dto) {
		Etablissement e = new Etablissement();
		e.setId(UUID.randomUUID().toString());
		e.setNom(dto.getNom());
		e.setType(dto.getType());
		e.setLocalisation(dto.getLocalisation());
		e.setScoreSouverainete(dto.getScoreSouverainete());

		if (dto.getParcInformatiqueId() != null) {
			ParcInformatique parc = parcRepository.findById(dto.getParcInformatiqueId())
					.orElseThrow(() -> new RuntimeException("Parc non trouvé : " + dto.getParcInformatiqueId()));
			e.setParcInformatique(parc);
		}

		return toDTO(etablissementRepository.save(e));
	}

	private EtablissementDTO toDTO(Etablissement e) {
		return EtablissementDTO.builder().id(e.getId()).nom(e.getNom()).type(e.getType())
				.localisation(e.getLocalisation()).scoreSouverainete(e.getScoreSouverainete())
				.parcInformatiqueId(e.getParcInformatique() != null ? e.getParcInformatique().getId() : null).build();
	}
}

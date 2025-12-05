package com.as.astraScriptum.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.as.astraScriptum.dto.ParcInformatiqueDTO;
import com.as.astraScriptum.model.ParcInformatique;
import com.as.astraScriptum.repository.ParcInformatiqueRepository;

@Service
public class ParcInformatiqueService {

	private final ParcInformatiqueRepository parcRepository;

	public ParcInformatiqueService(ParcInformatiqueRepository parcRepository) {
		this.parcRepository = parcRepository;
	}

	// Récupérer tous les parcs
	public List<ParcInformatiqueDTO> findAll() {
		return parcRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}

	// Récupérer un parc par id
	public ParcInformatiqueDTO findById(String id) {
		ParcInformatique parc = parcRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Parc informatique non trouvé : " + id));
		return toDTO(parc);
	}

	// Créer un parc
	public ParcInformatiqueDTO create(ParcInformatiqueDTO dto) {
		ParcInformatique parc = new ParcInformatique();
		parc.setId(UUID.randomUUID().toString());
		parc.setTotalOrdi(dto.getTotalOrdi());
		parc.setTotalObsolete(dto.getTotalObsolete());
		parc.setPosteSousLinux(dto.getPosteSousLinux());
		parc.setPosteSousWindows(dto.getPosteSousWindows());
		parc.setServeurs(dto.getServeurs());

		return toDTO(parcRepository.save(parc));
	}

	// Mettre à jour un parc
	public ParcInformatiqueDTO update(String id, ParcInformatiqueDTO dto) {
		ParcInformatique parc = parcRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Parc informatique non trouvé : " + id));

		parc.setTotalOrdi(dto.getTotalOrdi());
		parc.setTotalObsolete(dto.getTotalObsolete());
		parc.setPosteSousLinux(dto.getPosteSousLinux());
		parc.setPosteSousWindows(dto.getPosteSousWindows());
		parc.setServeurs(dto.getServeurs());

		return toDTO(parcRepository.save(parc));
	}

	// Supprimer un parc
	public void delete(String id) {
		if (!parcRepository.existsById(id)) {
			throw new RuntimeException("Parc informatique non trouvé : " + id);
		}
		parcRepository.deleteById(id);
	}

	// Mapping Entité -> DTO
	private ParcInformatiqueDTO toDTO(ParcInformatique p) {
		return ParcInformatiqueDTO.builder().id(p.getId()).totalOrdi(p.getTotalOrdi())
				.totalObsolete(p.getTotalObsolete()).posteSousLinux(p.getPosteSousLinux())
				.posteSousWindows(p.getPosteSousWindows()).serveurs(p.getServeurs()).build();
	}
}

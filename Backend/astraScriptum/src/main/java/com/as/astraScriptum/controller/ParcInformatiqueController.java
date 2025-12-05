package com.as.astraScriptum.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.astraScriptum.dto.ParcInformatiqueDTO;
import com.as.astraScriptum.service.ParcInformatiqueService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/parcs-informatiques")
public class ParcInformatiqueController {

	private final ParcInformatiqueService parcService;

	public ParcInformatiqueController(ParcInformatiqueService parcService) {
		this.parcService = parcService;
	}

	// GET /api/parcs-informatiques
	@GetMapping
	public ResponseEntity<List<ParcInformatiqueDTO>> getAll() {
		return ResponseEntity.ok(parcService.findAll());
	}

	// GET /api/parcs-informatiques/{id}
	@GetMapping("/{id}")
	public ResponseEntity<ParcInformatiqueDTO> getById(@PathVariable String id) {
		return ResponseEntity.ok(parcService.findById(id));
	}

	// POST /api/parcs-informatiques
	@PostMapping
	public ResponseEntity<ParcInformatiqueDTO> create(@Valid @RequestBody ParcInformatiqueDTO dto) {
		ParcInformatiqueDTO created = parcService.create(dto);
		return ResponseEntity.ok(created);
	}

	// PUT /api/parcs-informatiques/{id}
	@PutMapping("/{id}")
	public ResponseEntity<ParcInformatiqueDTO> update(@PathVariable String id,
			@Valid @RequestBody ParcInformatiqueDTO dto) {
		ParcInformatiqueDTO updated = parcService.update(id, dto);
		return ResponseEntity.ok(updated);
	}

	// DELETE /api/parcs-informatiques/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		parcService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

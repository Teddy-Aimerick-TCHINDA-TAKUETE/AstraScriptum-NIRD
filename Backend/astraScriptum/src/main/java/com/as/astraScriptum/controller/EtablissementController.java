package com.as.astraScriptum.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.astraScriptum.dto.EtablissementDTO;
import com.as.astraScriptum.service.EtablissementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/etablissements")
public class EtablissementController {

	private final EtablissementService etablissementService;

	public EtablissementController(EtablissementService etablissementService) {
		this.etablissementService = etablissementService;
	}

	// GET /api/etablissements
	@GetMapping
	public ResponseEntity<List<EtablissementDTO>> getAll() {
		return ResponseEntity.ok(etablissementService.findAll());
	}

	// POST /api/etablissements
	@PostMapping
	public ResponseEntity<EtablissementDTO> create(@Valid @RequestBody EtablissementDTO dto) {
		EtablissementDTO created = etablissementService.create(dto);
		return ResponseEntity.ok(created);
	}
}

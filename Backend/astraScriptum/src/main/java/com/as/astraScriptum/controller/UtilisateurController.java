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

import com.as.astraScriptum.dto.CreateUtilisateurDTO;
import com.as.astraScriptum.dto.UpdateUtilisateurDTO;
import com.as.astraScriptum.dto.UtilisateurDTO;
import com.as.astraScriptum.service.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

	private final UtilisateurService utilisateurService;

	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	// GET /api/utilisateurs
	@GetMapping
	public ResponseEntity<List<UtilisateurDTO>> getAll() {
		return ResponseEntity.ok(utilisateurService.findAll());
	}

	// GET /api/utilisateurs/{id}
	@GetMapping("/{id}")
	public ResponseEntity<UtilisateurDTO> getById(@PathVariable String id) {
		return ResponseEntity.ok(utilisateurService.findById(id));
	}

	// POST /api/utilisateurs
	@PostMapping
	public ResponseEntity<UtilisateurDTO> create(@RequestBody CreateUtilisateurDTO dto) {
		UtilisateurDTO created = utilisateurService.create(dto);
		return ResponseEntity.ok(created);
	}

	// PUT /api/utilisateurs/{id}
	@PutMapping("/{id}")
	public ResponseEntity<UtilisateurDTO> update(@PathVariable String id, @RequestBody UpdateUtilisateurDTO dto) {
		UtilisateurDTO updated = utilisateurService.update(id, dto);
		return ResponseEntity.ok(updated);
	}

	// DELETE /api/utilisateurs/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		utilisateurService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

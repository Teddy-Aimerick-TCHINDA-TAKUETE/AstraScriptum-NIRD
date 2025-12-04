package com.as.astraScriptum.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.astraScriptum.dto.ActionUtilisateurDTO;
import com.as.astraScriptum.service.ActionUtilisateurService;

@RestController
@RequestMapping("/api/actions")
public class ActionUtilisateurController {

	private final ActionUtilisateurService actionService;

	public ActionUtilisateurController(ActionUtilisateurService actionService) {
		this.actionService = actionService;
	}

	// GET /api/actions
	@GetMapping
	public ResponseEntity<List<ActionUtilisateurDTO>> getAll() {
		return ResponseEntity.ok(actionService.findAll());
	}

	// POST /api/actions
	@PostMapping
	public ResponseEntity<ActionUtilisateurDTO> create(@RequestBody ActionUtilisateurDTO dto) {
		ActionUtilisateurDTO created = actionService.create(dto);
		return ResponseEntity.ok(created);
	}
}

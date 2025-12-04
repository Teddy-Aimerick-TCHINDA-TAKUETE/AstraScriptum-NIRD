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

import com.as.astraScriptum.dto.ScenarioInteractifDTO;
import com.as.astraScriptum.service.ScenarioInteractifService;

@RestController
@RequestMapping("/api/scenarios")
public class ScenarioInteractifController {

	private final ScenarioInteractifService scenarioService;

	public ScenarioInteractifController(ScenarioInteractifService scenarioService) {
		this.scenarioService = scenarioService;
	}

	// GET /api/scenarios
	@GetMapping
	public ResponseEntity<List<ScenarioInteractifDTO>> getAll() {
		return ResponseEntity.ok(scenarioService.findAll());
	}

	// GET /api/scenarios/{id}
	@GetMapping("/{id}")
	public ResponseEntity<ScenarioInteractifDTO> getById(@PathVariable String id) {
		return ResponseEntity.ok(scenarioService.findById(id));
	}

	// POST /api/scenarios
	@PostMapping
	public ResponseEntity<ScenarioInteractifDTO> create(@RequestBody ScenarioInteractifDTO dto) {
		ScenarioInteractifDTO created = scenarioService.create(dto);
		return ResponseEntity.ok(created);
	}

	// PUT /api/scenarios/{id}
	@PutMapping("/{id}")
	public ResponseEntity<ScenarioInteractifDTO> update(@PathVariable String id,
			@RequestBody ScenarioInteractifDTO dto) {
		ScenarioInteractifDTO updated = scenarioService.update(id, dto);
		return ResponseEntity.ok(updated);
	}

	// DELETE /api/scenarios/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		scenarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

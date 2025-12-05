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

import com.as.astraScriptum.dto.LogicielDTO;
import com.as.astraScriptum.service.LogicielService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/logiciels")
public class LogicielController {

	private final LogicielService logicielService;

	public LogicielController(LogicielService logicielService) {
		this.logicielService = logicielService;
	}

	// GET /api/logiciels
	@GetMapping
	public ResponseEntity<List<LogicielDTO>> getAll() {
		return ResponseEntity.ok(logicielService.findAll());
	}

	// GET /api/logiciels/{id}
	@GetMapping("/{id}")
	public ResponseEntity<LogicielDTO> getById(@PathVariable String id) {
		return ResponseEntity.ok(logicielService.findById(id));
	}

	// POST /api/logiciels
	@PostMapping
	public ResponseEntity<LogicielDTO> create(@Valid @RequestBody LogicielDTO dto) {
		LogicielDTO created = logicielService.create(dto);
		return ResponseEntity.ok(created);
	}

	// PUT /api/logiciels/{id}
	@PutMapping("/{id}")
	public ResponseEntity<LogicielDTO> update(@PathVariable String id, @Valid @RequestBody LogicielDTO dto) {
		LogicielDTO updated = logicielService.update(id, dto);
		return ResponseEntity.ok(updated);
	}

	// DELETE /api/logiciels/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		logicielService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

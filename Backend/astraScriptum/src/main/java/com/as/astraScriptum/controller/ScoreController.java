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

import com.as.astraScriptum.dto.ScoreDTO;
import com.as.astraScriptum.service.ScoreService;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

	private final ScoreService scoreService;

	public ScoreController(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	// GET /api/scores
	@GetMapping
	public ResponseEntity<List<ScoreDTO>> getAll() {
		return ResponseEntity.ok(scoreService.findAll());
	}

	// GET /api/scores/{id}
	@GetMapping("/{id}")
	public ResponseEntity<ScoreDTO> getById(@PathVariable String id) {
		return ResponseEntity.ok(scoreService.findById(id));
	}

	// POST /api/scores
	@PostMapping
	public ResponseEntity<ScoreDTO> create(@RequestBody ScoreDTO dto) {
		ScoreDTO created = scoreService.create(dto);
		return ResponseEntity.ok(created);
	}

	// PUT /api/scores/{id}
	@PutMapping("/{id}")
	public ResponseEntity<ScoreDTO> update(@PathVariable String id, @RequestBody ScoreDTO dto) {
		ScoreDTO updated = scoreService.update(id, dto);
		return ResponseEntity.ok(updated);
	}

	// DELETE /api/scores/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		scoreService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

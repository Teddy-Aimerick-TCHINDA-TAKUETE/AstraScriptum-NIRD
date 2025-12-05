package com.as.astraScriptum.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.astraScriptum.dto.RecommendationIADTO;
import com.as.astraScriptum.service.RecommendationIAService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationIAController {

	private final RecommendationIAService recommendationIAService;

	public RecommendationIAController(RecommendationIAService recommendationIAService) {
		this.recommendationIAService = recommendationIAService;
	}

	// GET /api/recommendations
	@GetMapping
	public ResponseEntity<List<RecommendationIADTO>> getAll() {
		return ResponseEntity.ok(recommendationIAService.findAll());
	}

	// GET /api/recommendations/{id}
	@GetMapping("/{id}")
	public ResponseEntity<RecommendationIADTO> getById(@PathVariable String id) {
		return ResponseEntity.ok(recommendationIAService.findById(id));
	}

	// POST /api/recommendations
	@PostMapping
	public ResponseEntity<RecommendationIADTO> create(@Valid @RequestBody RecommendationIADTO dto) {
		RecommendationIADTO created = recommendationIAService.create(dto);
		return ResponseEntity.ok(created);
	}

	// DELETE /api/recommendations/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		recommendationIAService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

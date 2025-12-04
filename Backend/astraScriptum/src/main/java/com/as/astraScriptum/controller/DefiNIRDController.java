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

import com.as.astraScriptum.dto.DefiNIRDDTO;
import com.as.astraScriptum.service.DefiNIRDService;

@RestController
@RequestMapping("/api/defis")
public class DefiNIRDController {

	private final DefiNIRDService defiService;

	public DefiNIRDController(DefiNIRDService defiService) {
		this.defiService = defiService;
	}

	// GET /api/defis
	@GetMapping
	public ResponseEntity<List<DefiNIRDDTO>> getAll() {
		return ResponseEntity.ok(defiService.findAll());
	}

	// GET /api/defis/{id}
	@GetMapping("/{id}")
	public ResponseEntity<DefiNIRDDTO> getById(@PathVariable String id) {
		return ResponseEntity.ok(defiService.findById(id));
	}

	// POST /api/defis
	@PostMapping
	public ResponseEntity<DefiNIRDDTO> create(@RequestBody DefiNIRDDTO dto) {
		DefiNIRDDTO created = defiService.create(dto);
		return ResponseEntity.ok(created);
	}

	// PUT /api/defis/{id}
	@PutMapping("/{id}")
	public ResponseEntity<DefiNIRDDTO> update(@PathVariable String id, @RequestBody DefiNIRDDTO dto) {
		DefiNIRDDTO updated = defiService.update(id, dto);
		return ResponseEntity.ok(updated);
	}

	// DELETE /api/defis/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		defiService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

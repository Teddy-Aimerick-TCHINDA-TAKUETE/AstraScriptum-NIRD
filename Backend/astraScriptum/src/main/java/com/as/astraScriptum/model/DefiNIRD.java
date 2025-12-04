package com.as.astraScriptum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DefiNIRD {

	@Id
	private String id;

	private String titre;
	private String description;
	private int points;

	// Chaque défi est débloqué par un scénario
	@ManyToOne
	@JoinColumn(name = "scenario_id")
	private ScenarioInteractif scenario;
}

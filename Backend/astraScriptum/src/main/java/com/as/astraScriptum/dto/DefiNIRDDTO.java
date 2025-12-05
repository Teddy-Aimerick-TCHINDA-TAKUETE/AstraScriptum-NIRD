package com.as.astraScriptum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DefiNIRDDTO {

	private String id;
	private String titre;
	private String description;
	private int points;

	private String scenarioId;
}

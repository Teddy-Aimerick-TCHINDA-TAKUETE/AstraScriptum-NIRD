package com.as.astraScriptum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScenarioInteractifDTO {

	private String id;

	private String titre;
	private String question;

	private String choixA;
	private String choixB;
	private String choixC;

	private String consequenceA;
	private String consequenceB;
	private String consequenceC;
}

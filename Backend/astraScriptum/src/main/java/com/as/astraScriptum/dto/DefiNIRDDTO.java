package com.as.astraScriptum.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

	@NotBlank(message = "Le titre est obligatoire")
	private String titre;

	@NotBlank(message = "La description est obligatoire")
	private String description;

	@Min(value = 0, message = "Les points doivent être >= 0")
	private int points;

	@NotBlank(message = "Le scénario est obligatoire")
	private String scenarioId;
}

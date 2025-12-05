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
public class EtablissementDTO {

	private String id;

	@NotBlank(message = "Le nom est obligatoire")
	private String nom;

	@NotBlank(message = "Le type est obligatoire")
	private String type;

	@NotBlank(message = "La localisation est obligatoire")
	private String localisation;

	@Min(value = 0, message = "Le score souveraineté doit être >= 0")
	private int scoreSouverainete;

	private String parcInformatiqueId; // optionnel
}

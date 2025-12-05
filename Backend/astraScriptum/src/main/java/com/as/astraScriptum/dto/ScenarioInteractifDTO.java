package com.as.astraScriptum.dto;

import jakarta.validation.constraints.NotBlank;
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

	@NotBlank(message = "Le titre est obligatoire")
	private String titre;

	@NotBlank(message = "La question est obligatoire")
	private String question;

	@NotBlank(message = "Le choix A est obligatoire")
	private String choixA;

	@NotBlank(message = "Le choix B est obligatoire")
	private String choixB;

	@NotBlank(message = "Le choix C est obligatoire")
	private String choixC;

	@NotBlank(message = "La conséquence A est obligatoire")
	private String consequenceA;

	@NotBlank(message = "La conséquence B est obligatoire")
	private String consequenceB;

	@NotBlank(message = "La conséquence C est obligatoire")
	private String consequenceC;
}

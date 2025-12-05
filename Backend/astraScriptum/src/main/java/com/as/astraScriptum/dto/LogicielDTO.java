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
public class LogicielDTO {

	private String id;

	@NotBlank(message = "Le nom du logiciel est obligatoire")
	private String nom;

	@NotBlank(message = "La catégorie est obligatoire")
	private String categorie;

	private boolean libre;

	private boolean proprietaire;
}

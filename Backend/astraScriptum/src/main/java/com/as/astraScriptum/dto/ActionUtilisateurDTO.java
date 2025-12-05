package com.as.astraScriptum.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionUtilisateurDTO {

	private String id;

	@NotBlank(message = "L'action est obligatoire")
	private String action;

	@NotBlank(message = "L'impact est obligatoire")
	private String impact;

	private LocalDateTime date;

	@NotBlank(message = "L'utilisateur est obligatoire")
	private String utilisateurId;

	@NotBlank(message = "L'établissement est obligatoire")
	private String etablissementId;
}

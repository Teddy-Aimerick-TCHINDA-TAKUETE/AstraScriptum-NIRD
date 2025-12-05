package com.as.astraScriptum.dto;

import java.time.LocalDateTime;

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
	private String action;
	private String impact;
	private LocalDateTime date;

	private String utilisateurId;
	private String etablissementId;
}

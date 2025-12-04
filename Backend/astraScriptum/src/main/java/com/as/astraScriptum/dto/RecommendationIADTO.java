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
public class RecommendationIADTO {

	private String id;
	private String typeConseil;
	private String texte;
	private LocalDateTime dateCreation;

	// Utilisateur qui reçoit la reco
	private String destinataireId;
}

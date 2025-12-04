package com.as.astraScriptum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreDTO {

	private String id;
	private int souvNum;
	private int depBigTech;
	private int progressNIRD;

	// Lien vers l'utilisateur
	private String utilisateurId;
}

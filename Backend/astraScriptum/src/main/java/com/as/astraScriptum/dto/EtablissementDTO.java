package com.as.astraScriptum.dto;

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
	private String nom;
	private String type;
	private String localisation;
	private int scoreSouverainete;

	private String parcInformatiqueId;
}

package com.as.astraScriptum.dto;

import com.as.astraScriptum.model.TypeUtilisateur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UtilisateurDTO {

	private String id;
	private String nom;
	private String mail;
	private TypeUtilisateur type;
}

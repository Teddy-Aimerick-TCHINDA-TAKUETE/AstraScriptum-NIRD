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
public class UpdateUtilisateurDTO {

	private String nom;
	private String mail;
	private TypeUtilisateur type;

	// Si plus tard tu veux gérer le changement de mdp,
	// on fera un DTO séparé pour ça (ChangePasswordDTO).
}

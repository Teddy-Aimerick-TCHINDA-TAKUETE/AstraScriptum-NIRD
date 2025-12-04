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
public class CreateUtilisateurDTO {

	private String nom;
	private String mail;
	private TypeUtilisateur type;

	// Mot de passe en clair reçu du front
	// → sera encodé dans le Service avant de sauvegarder
	private String password;
}

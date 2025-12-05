package com.as.astraScriptum.dto;

import com.as.astraScriptum.model.TypeUtilisateur;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUtilisateurDTO {

	@NotBlank(message = "Le nom ne peut pas être vide")
	private String nom;

	@NotBlank(message = "Le mail est obligatoire")
	@Email(message = "Format email invalide")
	private String mail;

	@NotNull(message = "Le type d'utilisateur est obligatoire")
	private TypeUtilisateur type;

	// Si plus tard tu veux gérer le changement de mdp,
	// on fera un DTO séparé pour ça (ChangePasswordDTO).
}

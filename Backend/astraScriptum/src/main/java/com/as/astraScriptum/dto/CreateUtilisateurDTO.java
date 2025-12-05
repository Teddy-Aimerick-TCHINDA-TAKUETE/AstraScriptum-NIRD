package com.as.astraScriptum.dto;

import com.as.astraScriptum.model.TypeUtilisateur;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUtilisateurDTO {

	@NotBlank(message = "Le nom ne peut pas être vide")
	private String nom;

	@NotBlank(message = "Le mail est obligatoire")
	@Email(message = "Format email invalide")
	private String mail;

	@NotNull(message = "Le type d'utilisateur est obligatoire")
	private TypeUtilisateur type;

	@NotBlank(message = "Le mot de passe est obligatoire")
	@Size(min = 6, message = "Le mot de passe doit contenir au minimum 6 caractères")
	private String password;
}

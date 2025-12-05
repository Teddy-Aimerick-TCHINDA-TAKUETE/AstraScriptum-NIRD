package com.as.astraScriptum.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO {

	@NotBlank(message = "L'email est obligatoire")
	private String mail;

	@NotBlank(message = "Le mot de passe est obligatoire")
	private String password;
}

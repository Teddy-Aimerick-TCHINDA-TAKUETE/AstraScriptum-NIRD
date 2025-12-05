package com.as.astraScriptum.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

	@NotBlank(message = "Le type de conseil est obligatoire")
	private String typeConseil;

	@NotBlank(message = "Le texte de recommandation ne peut pas être vide")
	@Size(min = 3, message = "Le texte doit contenir au minimum 3 caractères")
	private String texte;

	private LocalDateTime dateCreation;

	@NotBlank(message = "Le destinataire est obligatoire")
	private String destinataireId;
}

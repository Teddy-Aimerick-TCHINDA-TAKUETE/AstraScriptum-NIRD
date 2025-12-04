package com.as.astraScriptum.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendationIA {

	@Id
	private String id;

	private String typeConseil;

	@Column(length = 2000)
	private String texte;

	private LocalDateTime dateCreation;

	// Un utilisateur peut recevoir plusieurs recommandations
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur destinataire;
}

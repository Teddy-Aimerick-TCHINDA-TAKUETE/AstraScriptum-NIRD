package com.as.astraScriptum.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilisateur {

	@Id
	private String id;

	private String nom;
	private String mail;

	@Enumerated(EnumType.STRING)
	private TypeUtilisateur type;

	// Un utilisateur possède 0..* scores
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Score> scores;

	// Un utilisateur réalise 1..* actions
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ActionUtilisateur> actions;

	// Un utilisateur peut recevoir plusieurs recommandations IA
	@OneToMany(mappedBy = "destinataire", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RecommendationIA> recommandations;
}

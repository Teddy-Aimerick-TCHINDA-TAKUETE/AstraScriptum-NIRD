package com.as.astraScriptum.model;

import java.time.LocalDateTime;

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
public class ActionUtilisateur {

	@Id
	private String id;

	private String action;
	private String impact;
	private LocalDateTime date;

	// Réalisée par un utilisateur
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;

	// Impacte un établissement
	@ManyToOne
	@JoinColumn(name = "etablissement_id")
	private Etablissement etablissement;
}

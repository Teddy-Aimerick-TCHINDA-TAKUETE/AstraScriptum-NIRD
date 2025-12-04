package com.as.astraScriptum.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class ScenarioInteractif {

	@Id
	private String id;

	private String titre;
	private String question;

	private String choixA;
	private String choixB;
	private String choixC;

	private String consequenceA;
	private String consequenceB;
	private String consequenceC;

	// Many-to-many avec Etablissement
	@ManyToMany(mappedBy = "scenarios")
	private List<Etablissement> etablissements;

	// 1 scénario débloque 1..* défis
	@OneToMany(mappedBy = "scenario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DefiNIRD> defis;
}

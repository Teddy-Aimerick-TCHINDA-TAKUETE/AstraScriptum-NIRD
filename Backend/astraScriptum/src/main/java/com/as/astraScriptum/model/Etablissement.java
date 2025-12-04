package com.as.astraScriptum.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Etablissement {

	@Id
	private String id;

	private String nom;
	private String type;
	private String localisation;
	private int scoreSouverainete;

	// Un établissement peut avoir plusieurs actions qui l’impactent
	@OneToMany(mappedBy = "etablissement", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ActionUtilisateur> actions;

	// Many-to-many avec Logiciel (0..* <-> 0..*)
	@ManyToMany
	@JoinTable(name = "etablissement_logiciel", joinColumns = @JoinColumn(name = "etablissement_id"), inverseJoinColumns = @JoinColumn(name = "logiciel_id"))
	private List<Logiciel> logiciels;

	// Un établissement est associé à un parc informatique
	@ManyToOne
	@JoinColumn(name = "parc_informatique_id")
	private ParcInformatique parcInformatique;

	// Many-to-many avec ScenarioInteractif (Intervenir)
	@ManyToMany
	@JoinTable(name = "etablissement_scenario", joinColumns = @JoinColumn(name = "etablissement_id"), inverseJoinColumns = @JoinColumn(name = "scenario_id"))
	private List<ScenarioInteractif> scenarios;
}

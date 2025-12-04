package com.as.astraScriptum.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Logiciel {

	@Id
	private String id;

	private String nom;
	private String categorie;
	private boolean libre;
	private boolean proprietaire;

	@ManyToMany(mappedBy = "logiciels")
	private List<Etablissement> etablissements;
}

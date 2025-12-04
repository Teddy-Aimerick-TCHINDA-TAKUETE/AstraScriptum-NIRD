package com.as.astraScriptum.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
public class ParcInformatique {

	@Id
	private String id;

	private int totalOrdi;
	private int totalObsolete;
	private int posteSousLinux;
	private int posteSousWindows;
	private int serveurs;

	// Un parc peut être lié à plusieurs établissements (selon ton diagramme 1..*)
	@OneToMany(mappedBy = "parcInformatique", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Etablissement> etablissements;
}

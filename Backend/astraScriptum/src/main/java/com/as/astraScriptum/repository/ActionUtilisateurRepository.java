package com.as.astraScriptum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.astraScriptum.model.ActionUtilisateur;

public interface ActionUtilisateurRepository extends JpaRepository<ActionUtilisateur, String> {

	List<ActionUtilisateur> findByUtilisateurId(String utilisateurId);

	List<ActionUtilisateur> findByEtablissementId(String etablissementId);
}

package com.as.astraScriptum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.astraScriptum.model.Logiciel;

public interface LogicielRepository extends JpaRepository<Logiciel, String> {

	List<Logiciel> findByCategorie(String categorie);

	List<Logiciel> findByLibreTrue();

	List<Logiciel> findByProprietaireTrue();
}

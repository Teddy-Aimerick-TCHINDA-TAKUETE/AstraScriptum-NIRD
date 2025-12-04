package com.as.astraScriptum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.astraScriptum.model.Etablissement;

public interface EtablissementRepository extends JpaRepository<Etablissement, String> {

	List<Etablissement> findByType(String type);

	List<Etablissement> findByLocalisation(String localisation);
}

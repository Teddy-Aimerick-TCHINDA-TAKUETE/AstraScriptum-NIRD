package com.as.astraScriptum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.astraScriptum.model.ScenarioInteractif;

public interface ScenarioInteractifRepository extends JpaRepository<ScenarioInteractif, String> {

	List<ScenarioInteractif> findByTitreContainingIgnoreCase(String titre);
}

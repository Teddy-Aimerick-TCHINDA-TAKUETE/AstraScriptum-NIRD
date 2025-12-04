package com.as.astraScriptum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.astraScriptum.model.RecommendationIA;

public interface RecommendationIARepository extends JpaRepository<RecommendationIA, String> {

	// Exemple : recommandations pour un utilisateur donné
	List<RecommendationIA> findByDestinataireId(String utilisateurId);
}

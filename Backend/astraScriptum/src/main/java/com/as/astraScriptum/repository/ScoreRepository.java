package com.as.astraScriptum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.astraScriptum.model.Score;

public interface ScoreRepository extends JpaRepository<Score, String> {

	// Exemple : tous les scores d'un utilisateur
	List<Score> findByUtilisateurId(String utilisateurId);
}

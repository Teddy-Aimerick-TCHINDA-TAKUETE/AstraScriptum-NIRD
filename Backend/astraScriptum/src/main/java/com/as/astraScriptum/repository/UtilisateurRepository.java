package com.as.astraScriptum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.astraScriptum.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

	// Exemple : trouver un utilisateur par mail
	Optional<Utilisateur> findByMail(String mail);
}

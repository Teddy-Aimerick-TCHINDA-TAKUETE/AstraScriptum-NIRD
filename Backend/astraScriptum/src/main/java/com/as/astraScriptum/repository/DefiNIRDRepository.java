package com.as.astraScriptum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.astraScriptum.model.DefiNIRD;

public interface DefiNIRDRepository extends JpaRepository<DefiNIRD, String> {

	List<DefiNIRD> findByPointsGreaterThanEqual(int pointsMin);
}

package com.as.astraScriptum.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreDTO {

	private String id;

	@Min(value = 0, message = "Le score souvNum doit être >= 0")
	private int souvNum;

	@Min(value = 0, message = "Le score depBigTech doit être >= 0")
	private int depBigTech;

	@Min(value = 0, message = "Le score progressNIRD doit être >= 0")
	private int progressNIRD;

	@NotBlank(message = "L'utilisateur est obligatoire")
	private String utilisateurId;
}

package com.as.astraScriptum.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParcInformatiqueDTO {

	private String id;

	@Min(value = 0)
	private int totalOrdi;

	@Min(value = 0)
	private int totalObsolete;

	@Min(value = 0)
	private int posteSousLinux;

	@Min(value = 0)
	private int posteSousWindows;

	@Min(value = 0)
	private int serveurs;
}

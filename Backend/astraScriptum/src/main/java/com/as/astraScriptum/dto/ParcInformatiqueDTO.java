package com.as.astraScriptum.dto;

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

	private int totalOrdi;
	private int totalObsolete;
	private int posteSousLinux;
	private int posteSousWindows;
	private int serveurs;
}

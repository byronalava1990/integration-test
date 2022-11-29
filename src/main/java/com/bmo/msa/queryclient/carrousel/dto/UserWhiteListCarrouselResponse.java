package com.bmo.msa.queryclient.carrousel.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserWhiteListCarrouselResponse {

	private boolean existsInCarrouselDataBase;

}

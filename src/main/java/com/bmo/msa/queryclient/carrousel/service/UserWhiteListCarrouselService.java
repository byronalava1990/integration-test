package com.bmo.msa.queryclient.carrousel.service;

import org.springframework.http.ResponseEntity;

import com.bmo.msa.queryclient.carrousel.dto.UserWhiteListCarrouselDTO;
import com.bmo.msa.queryclient.carrousel.dto.UserWhiteListCarrouselResponse;

@FunctionalInterface
public interface UserWhiteListCarrouselService {

	ResponseEntity<UserWhiteListCarrouselResponse> findUserWhiteListCarrouselByUuid(
			UserWhiteListCarrouselDTO userWhiteListCarrouselDTO);

}

package com.bmo.msa.queryclient.carrousel.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bmo.msa.queryclient.carrousel.dto.UserWhiteListCarrouselDTO;
import com.bmo.msa.queryclient.carrousel.dto.UserWhiteListCarrouselResponse;
import com.bmo.msa.queryclient.carrousel.service.imp.UserWhiteListCarrouselServiceImp;
import com.bmo.msa.queryclient.carrousel.util.RequestContext;
import com.pichincha.centrodigital.app.libcorelogger.service.LoggerUtil;

@RestController
public class UserWhiteListCarrouselController {

	@Autowired
	private UserWhiteListCarrouselServiceImp userFavoriteProductService;
	@Autowired
	private LoggerUtil log;
	@Autowired
	private RequestContext requestContext;

	@PostMapping("/app/msa/query/client/carrousel/v1")
	public ResponseEntity<UserWhiteListCarrouselResponse> findClientInCarrouselDatabase(
			@RequestBody UserWhiteListCarrouselDTO requestUserWhiteListCarrousel) {
		var method = "findClientInCarrouselDatabase";
		initSession();
		log.appRequest(requestUserWhiteListCarrousel, requestContext.getSession(), method);
		var response = userFavoriteProductService.findUserWhiteListCarrouselByUuid(requestUserWhiteListCarrousel);
		log.appResponse(response, requestContext.getSession(), method);
		return response;
	}

	private void initSession() {
		requestContext.setSession(UUID.randomUUID().toString());
	}

}

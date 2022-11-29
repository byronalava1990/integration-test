package com.bmo.msa.queryclient.carrousel.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bmo.msa.queryclient.carrousel.dto.UserWhiteListCarrouselDTO;
import com.bmo.msa.queryclient.carrousel.dto.UserWhiteListCarrouselResponse;
import com.bmo.msa.queryclient.carrousel.service.imp.UserWhiteListCarrouselServiceImp;
import com.bmo.msa.queryclient.carrousel.util.RequestContext;
import com.pichincha.centrodigital.app.libcorelogger.service.LoggerUtil;

@ExtendWith(MockitoExtension.class)
class UserWhiteListCarrouselControllerTest {

	@InjectMocks
	private UserWhiteListCarrouselController userWhiteListCarrouselController;
	@Mock
	private UserWhiteListCarrouselServiceImp userFavoriteProductService;
	@Mock
	private LoggerUtil log;
	@Mock
	private RequestContext requestContext;

	@Test
	public void shouldFindClientInCarrouselDatabaseThenReturnTrue() {

		Mockito.when(userFavoriteProductService
				.findUserWhiteListCarrouselByUuid(Mockito.any(UserWhiteListCarrouselDTO.class)))
				.thenReturn(ResponseEntity
						.ok(UserWhiteListCarrouselResponse.builder().existsInCarrouselDataBase(true).build()));
		
		var responseControllerCarrousel = userWhiteListCarrouselController.findClientInCarrouselDatabase(UserWhiteListCarrouselDTO.builder().userUuid("test").build());
		Assertions.assertEquals(HttpStatus.OK,responseControllerCarrousel.getStatusCode());
	}

}

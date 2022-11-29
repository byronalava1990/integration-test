package com.bmo.msa.queryclient.carrousel.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bmo.msa.queryclient.carrousel.dto.UserWhiteListCarrouselDTO;
import com.bmo.msa.queryclient.carrousel.entity.UserWhiteListCarrousel;
import com.bmo.msa.queryclient.carrousel.repository.UserWhiteListCarrouselRepository;
import com.bmo.msa.queryclient.carrousel.service.imp.UserWhiteListCarrouselServiceImp;
import com.bmo.msa.queryclient.carrousel.util.RequestContext;
import com.pichincha.centrodigital.app.libcorelogger.service.LoggerUtil;

@ExtendWith(MockitoExtension.class)
public class UserWhiteListCarrouselServiceTest {

	@InjectMocks
	private UserWhiteListCarrouselServiceImp userWhiteListCarrouselService;

	@Mock
	private UserWhiteListCarrouselRepository userWhiteListCarrouselRepository;

	@Mock
	private LoggerUtil log;

	@Mock
	private RequestContext requestContext;

	@Test
	public void shouldFindUserWhiteListCarrouselByUuidThenReturnTrue() {

		Mockito.when(userWhiteListCarrouselRepository.findUserWhiteListCarrouselByUserUuid(Mockito.anyString()))
				.thenReturn(UserWhiteListCarrousel.builder().userIdentification("999").userUuid("123").build());
		var responseService = userWhiteListCarrouselService
				.findUserWhiteListCarrouselByUuid(UserWhiteListCarrouselDTO.builder().userUuid("123").build());
		Assertions.assertTrue(responseService.getBody().isExistsInCarrouselDataBase());
	}

	@Test
	public void shouldFindUserWhiteListCarrouselByUuidThenReturnFalse() {
		Mockito.when(userWhiteListCarrouselRepository.findUserWhiteListCarrouselByUserUuid(Mockito.anyString()))
				.thenReturn(UserWhiteListCarrousel.builder().build());
		var responseService = userWhiteListCarrouselService
				.findUserWhiteListCarrouselByUuid(UserWhiteListCarrouselDTO.builder().userUuid("123").build());
		Assertions.assertFalse(responseService.getBody().isExistsInCarrouselDataBase());
	}

	@Test
	public void shouldFindUserWhiteListCarrouselByUuidThenThrowException() {

		Mockito.when(userWhiteListCarrouselRepository.findUserWhiteListCarrouselByUserUuid(Mockito.anyString()))
				.thenThrow(RuntimeException.class);
		Assertions.assertThrows(RuntimeException.class, () -> {
			userWhiteListCarrouselService
					.findUserWhiteListCarrouselByUuid(UserWhiteListCarrouselDTO.builder().userUuid("123").build());
		});

	}

}

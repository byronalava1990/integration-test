package com.bmo.msa.queryclient.carrousel.service.imp;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bmo.msa.queryclient.carrousel.dto.UserWhiteListCarrouselDTO;
import com.bmo.msa.queryclient.carrousel.dto.UserWhiteListCarrouselResponse;
import com.bmo.msa.queryclient.carrousel.repository.UserWhiteListCarrouselRepository;
import com.bmo.msa.queryclient.carrousel.service.UserWhiteListCarrouselService;
import com.bmo.msa.queryclient.carrousel.util.RequestContext;
import com.pichincha.centrodigital.app.libcorelogger.service.LoggerUtil;

@Service
public class UserWhiteListCarrouselServiceImp implements UserWhiteListCarrouselService {

	@Autowired
	private UserWhiteListCarrouselRepository userWhiteListCarrouselRepository;

	@Autowired
	private LoggerUtil log;

	@Autowired
	private RequestContext requestContext;

	public ResponseEntity<UserWhiteListCarrouselResponse> findUserWhiteListCarrouselByUuid(
			UserWhiteListCarrouselDTO userWhiteListCarrouselDTO) {
		var method = "findUserWhiteListCarrouselByUuid";
		var errorResponse = ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(UserWhiteListCarrouselResponse.builder().existsInCarrouselDataBase(false).build());
		log.request(userWhiteListCarrouselDTO, requestContext.getSession(), method);
		var repositoryResponse = userWhiteListCarrouselRepository
				.findUserWhiteListCarrouselByUserUuid(userWhiteListCarrouselDTO.getUserUuid());
		log.response(repositoryResponse, requestContext.getSession(), method);

		if (Objects.nonNull(repositoryResponse) && Objects.nonNull(repositoryResponse.getUserIdentification())) {
			return ResponseEntity.ok(UserWhiteListCarrouselResponse.builder().existsInCarrouselDataBase(true).build());
		}
		return errorResponse;
	}
}

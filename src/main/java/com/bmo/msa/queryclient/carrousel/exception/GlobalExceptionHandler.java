package com.bmo.msa.queryclient.carrousel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bmo.msa.queryclient.carrousel.dto.UserWhiteListCarrouselResponse;
import com.bmo.msa.queryclient.carrousel.util.RequestContext;
import com.pichincha.centrodigital.app.libcorelogger.service.LoggerUtil;

import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {
	private final LoggerUtil log;
	private final RequestContext requestContext;

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
	public UserWhiteListCarrouselResponse generalExceptionHandler(Exception e) {
		String method = "generalExceptionHandler";
		log.setHttpstatus(HttpStatus.PRECONDITION_FAILED).exception(e, requestContext.getSession(), method);
		var response = UserWhiteListCarrouselResponse.builder().build();
		log.appResponse(response, requestContext.getSession(), method);
		return response;
	}

}

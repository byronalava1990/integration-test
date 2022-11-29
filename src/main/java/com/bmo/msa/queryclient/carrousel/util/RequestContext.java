package com.bmo.msa.queryclient.carrousel.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.Data;

@Component
@Data
@RequestScope
public class RequestContext {
	private String session;
}

package com.bmo.msa.queryclient.carrousel.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserWhiteListCarrouselDTO {

	@NotNull(message = "Uuid must not be null")
	@NotEmpty(message = "Uuid must not be empty")
	private String userUuid;
	private String identification;
	private String state;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp creationDate;

}

package com.bmo.msa.queryclient.carrousel.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_white_list_carrousel")
@Builder
public class UserWhiteListCarrousel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userWhiteListCarrouselId;
	
	@Column(name = "user_identification",unique = true)
	private String userIdentification;

	@Column(name = "user_uuid")
	private String userUuid;
	
    @Column(name = "creation_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp creationDate;

	@Column(name = "user_state")
	private String userState;

}

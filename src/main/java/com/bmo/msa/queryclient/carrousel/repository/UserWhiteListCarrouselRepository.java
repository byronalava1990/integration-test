package com.bmo.msa.queryclient.carrousel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bmo.msa.queryclient.carrousel.entity.UserWhiteListCarrousel;

public interface UserWhiteListCarrouselRepository extends CrudRepository<UserWhiteListCarrousel, Long> {

	@Query(value = "SELECT ufp.* FROM user_white_list_carrousel ufp WHERE ufp.user_uuid = :uuid and user_state ='A'", nativeQuery = true)
	UserWhiteListCarrousel findUserWhiteListCarrouselByUserUuid(@Param("uuid") String uuid);
	
	@Query(value = "SELECT ufp.* FROM user_white_list_carrousel ufp ", nativeQuery = true)
	List<UserWhiteListCarrousel> findAllUsers();

}

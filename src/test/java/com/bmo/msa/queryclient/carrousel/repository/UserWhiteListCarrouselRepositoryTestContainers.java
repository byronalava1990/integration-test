package com.bmo.msa.queryclient.carrousel.repository;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.testcontainers.containers.PostgreSQLContainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestExecutionListeners;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.bmo.msa.queryclient.carrousel.entity.UserWhiteListCarrousel;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserWhiteListCarrouselRepositoryTestContainers {

	@Autowired
	private UserWhiteListCarrouselRepository repository;

	@DynamicPropertySource
	static void postgresqlProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
		registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
		registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
	}

	@Container
	public static PostgreSQLContainer postgreSQLContainer = 
	new PostgreSQLContainer("postgres:14-alpine")
			.withDatabaseName("integration-tests-db")
			.withPassword("inmemory")
			.withUsername("inmemory");
	
	@BeforeEach
	void setup() {
		repository.deleteAll();
	}

	@Test
	public void shouldSaveAndReadUserWhiteList() {

		repository.save(UserWhiteListCarrousel.builder().userIdentification("9999999999").userUuid("123").userState("A")
				.creationDate(new Timestamp(System.currentTimeMillis())).build());

		List<UserWhiteListCarrousel> listUserWhiteListCarrousel = repository.findAllUsers();

		assert !listUserWhiteListCarrousel.isEmpty();
		assert listUserWhiteListCarrousel.get(0).getUserIdentification().equalsIgnoreCase("9999999999");
		assert listUserWhiteListCarrousel.size() == 1;

	}

}

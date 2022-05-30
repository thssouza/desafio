package com.atech.desafio.voos.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.atech.desafio.voos.config.DatabaseConfig;
import com.atech.desafio.voos.model.Pilot;

@ContextConfiguration(classes= {DatabaseConfig.class},loader=AnnotationConfigContextLoader.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase
@EnableJpaRepositories(basePackages="com.atech.desafio.voos.repository")
@Sql("classpath:sql/insert_pilot.sql")
class PilotRepositoryTest {

	@Autowired
	private PilotRepository pilotRepository;

	@Test
	void findByIdTest() {
		Optional<Pilot> pilot = pilotRepository.findById(Long.valueOf(1));

		assertTrue(pilot.isPresent());
		assertEquals(Long.valueOf(1), pilot.get().getId());
		assertEquals("Joao da Silva", pilot.get().getName());
	}

}

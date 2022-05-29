package com.atech.desafio.voos.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.atech.desafio.voos.config.DatabaseConfig;
import com.atech.desafio.voos.model.Pilot;

@ContextConfiguration(classes= {DatabaseConfig.class},loader=AnnotationConfigContextLoader.class)
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@EnableJpaRepositories(basePackages="com.atech.desafio.voos.repository")
@Sql("classpath:sql/insert_pilot.sql")
public class PilotRepositoryTest {

	@Autowired
	private PilotRepository pilotRepository;

	@Test
	public void findByIdTest() {
		Optional<Pilot> pilot = pilotRepository.findById(Long.valueOf(1));

		assertTrue(pilot.isPresent());
		assertEquals(Long.valueOf(1), pilot.get().getId());
		assertEquals("Teste1", pilot.get().getName());
	}

}

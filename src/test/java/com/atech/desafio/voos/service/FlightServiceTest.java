package com.atech.desafio.voos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.atech.desafio.voos.config.DatabaseConfig;
import com.atech.desafio.voos.model.filter.FlightFilter;
import com.atech.desafio.voos.model.transfer.FlightDTO;

@ContextConfiguration(classes= {DatabaseConfig.class},loader=AnnotationConfigContextLoader.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase
@EnableJpaRepositories(basePackages="com.atech.desafio.voos.repository")
@ComponentScan(basePackages="com.atech.desafio.voos.service")
@Sql("classpath:sql/insert_pilot.sql")
class FlightServiceTest {

	@Autowired
	private FlightService flightService;

	@Test
	@Disabled
	void findByFilter() throws ParseException {

		FlightFilter flightFilter = new FlightFilter();

		flightFilter.setPilotName("Joao");

		List<FlightDTO> flightDTOs = flightService.findByFilter(flightFilter);

		assertEquals(2, flightDTOs.size());

		for (FlightDTO flightDTO:flightDTOs) {

			assertTrue(flightDTO.getPilotName().toUpperCase().contains( "JOAO"));

		}


	}

}

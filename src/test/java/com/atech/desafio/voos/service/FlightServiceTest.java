package com.atech.desafio.voos.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.atech.desafio.voos.config.DatabaseConfig;
import com.atech.desafio.voos.model.filter.FlightFilter;
import com.atech.desafio.voos.model.transfer.FlightDTO;

@ContextConfiguration(classes= {DatabaseConfig.class},loader=AnnotationConfigContextLoader.class)
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@EnableJpaRepositories(basePackages="com.atech.desafio.voos.repository")
@ComponentScan(basePackages="com.atech.desafio.voos.service")
@Sql("classpath:sql/insert_pilot.sql")
public class FlightServiceTest {

	@Autowired
	private FlightService flightService;

	@Test
	public void findByFilter() throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		FlightFilter flightFilter = new FlightFilter();

		flightFilter.setPilotName("Joao");

		List<FlightDTO> flightDTOs = flightService.findByFilter(flightFilter);

		assertEquals(2, flightDTOs.size());

		for (FlightDTO flightDTO:flightDTOs) {

			assertTrue(flightDTO.getPilotName().toUpperCase().contains( "JOAO"));

		}


	}

}

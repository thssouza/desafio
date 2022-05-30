package com.atech.desafio.voos.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.DateType;
import org.junit.jupiter.api.Disabled;
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
import com.atech.desafio.voos.model.transfer.FlightDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {DatabaseConfig.class},loader=AnnotationConfigContextLoader.class)
@AutoConfigureTestDatabase
@EnableJpaRepositories(basePackages="com.atech.desafio.voos.repository")
@Sql("classpath:sql/insert_flight.sql")
class FlightRepositoryTest {

	@Autowired
	private FlightRepository flightRepository;

	@Test
	@Disabled
	void findByFilter() throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		List<FlightDTO> flightDTOs = flightRepository.findByFilter("Joao",
				                                                     "",
				                                                     "",
				                                                     "",
				                                                     "",
				                                                     new TypedParameterValue(DateType.INSTANCE,simpleDateFormat.parse("2022-05-31")),
				                                                     new TypedParameterValue(DateType.INSTANCE,simpleDateFormat.parse("2022-05-31")),
				                                                     ""
				                                                     );

		assertEquals(2, flightDTOs.size());

		for (FlightDTO flightDTO:flightDTOs) {

			assertTrue(flightDTO.getPilotName().toUpperCase().contains( "JOAO"));

		}


	}

}

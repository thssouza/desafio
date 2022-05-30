package com.atech.desafio.voos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.atech.desafio.voos.model.City;
import com.atech.desafio.voos.model.Flight;
import com.atech.desafio.voos.model.Pilot;
import com.atech.desafio.voos.model.Plane;
import com.atech.desafio.voos.model.Status;
import com.atech.desafio.voos.model.transfer.FlightDTO;
import com.atech.desafio.voos.repository.FlightRepository;

@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = {"com.atech.desafio.voos"})
@EnableJpaRepositories(basePackages = "com.atech.desafio.voos.repository")
@ExtendWith(MockitoExtension.class)
class FlightServiceUnitTest {

	@Mock
	private FlightRepository flightRepository;

	@Autowired
	@InjectMocks
	private FlightService flightService;

	@Test
	void findByIdUnityTest() throws ParseException {
		final Flight flight = new Flight();
		final Pilot pilot = new Pilot();
		final Status status = new Status();
		final Plane plane = new Plane();
		final City cityArrive = new City();
		final City cityDepart = new City();

		SimpleDateFormat dataSaida = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		pilot.setId(Long.valueOf(1));
		pilot.setName("TesteNome");
		pilot.setActive(true);

		status.setId(Long.valueOf(1));
		status.setDescription("TesteStatus");

		cityDepart.setId(Long.valueOf(1));
		cityDepart.setName("TesteCidadePartida");

		cityArrive.setId(Long.valueOf(2));
		cityArrive.setName("TesteCidadeChegada");

		plane.setId(Long.valueOf(1));
		plane.setModel("ModeloTeste");
		plane.setTailCode("TailTeste");

		flight.setId(Long.valueOf(1));
		flight.setPilot(pilot);
		flight.setPlane(plane);
		flight.setStatus(status);
		flight.setCityDepart(cityDepart);
		flight.setCityArrive(cityArrive);
		flight.setDepartTime(dataSaida.parse("31/05/2022 17:25:00"));
		flight.setArriveTime(dataSaida.parse("31/05/2022 18:25:00"));

		final Optional<Flight> optionalFlight = Optional.of(flight);
		when(flightRepository.findById(any(Long.class))).thenReturn(optionalFlight);

		final Optional<FlightDTO> foundFlight = flightService.findById(Long.valueOf(1));

		assertTrue(foundFlight.isPresent());
		assertEquals(Long.valueOf(1), foundFlight.get().getId());
		assertEquals("TailTeste",foundFlight.get().getPlaneTailCode());

	}



}

package com.atech.desafio.voos.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.atech.desafio.voos.model.Pilot;
import com.atech.desafio.voos.model.transfer.PilotDTO;
import com.atech.desafio.voos.repository.PilotRepository;

@RunWith(MockitoJUnitRunner.class)
@ComponentScan(basePackages = {"com.atech.desafio.voos"})
@EnableJpaRepositories(basePackages = "com.atech.desafio.voos.repository")
@ExtendWith(MockitoExtension.class)
public class PilotServiceUnitTest {

	@Mock
	private PilotRepository pilotRepository;

	@Autowired
	@InjectMocks
	private PilotService pilotService;

	@Test
	public void findByIdUnityTest() {
		final Pilot pilot = new Pilot();
		pilot.setId(Long.valueOf(1));
		pilot.setName("Teste1");
		pilot.setActive(true);

		final Optional<Pilot> optionalPilot = Optional.of(pilot);
		when(pilotRepository.findById(any(Long.class))).thenReturn(optionalPilot);

		final Optional<PilotDTO> foundPilot = pilotService.findById(Long.valueOf(2));

		assertTrue(foundPilot.isPresent());
		assertEquals(Long.valueOf(1), foundPilot.get().getId());
		assertEquals("Teste1", foundPilot.get().getName());
		assertTrue(foundPilot.get().isActive());

	}


}

package com.atech.desafio.voos.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atech.desafio.voos.model.filter.FlightFilter;
import com.atech.desafio.voos.model.transfer.FlightDTO;
import com.atech.desafio.voos.service.FlightService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/desafio/flight")
@Tag(name="Voos",description="Ações referentes aos Voos")
public class FlightResource {

	private FlightService flightService;

	@GetMapping("/{id}")
	@Operation(description = "Busca Voos por ID")
	public ResponseEntity<Optional<FlightDTO>> findById(@PathVariable final Long id){

		Optional<FlightDTO> flightDTO = flightService.findById(id);

		if (flightDTO.isPresent()){
			return ResponseEntity.ok(flightDTO);
		} else {
			return ResponseEntity.noContent().build();
		}

	}


	@GetMapping("/filter")
	@Operation(description = "Busca Voos utilizando filtros")
	public ResponseEntity<List<FlightDTO>> findByFilter(final FlightFilter flightFilter ) {

		List<FlightDTO> flightDTOs = flightService.findByFilter(flightFilter);

		if (flightDTOs.isEmpty()){
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(flightDTOs);
		}

	}

}

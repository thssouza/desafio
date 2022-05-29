package com.atech.desafio.voos.resource;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atech.desafio.voos.model.transfer.PilotDTO;
import com.atech.desafio.voos.service.PilotService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/desafio/pilot")
@Tag(name="Piloto",description="Ações referentes a Piloto")
public class PilotResource {

	private PilotService pilotService;

	@GetMapping("/{id}")
	@Operation(description = "Busca Pilotos por ID")
	public ResponseEntity<Optional<PilotDTO>> findById(@PathVariable final Long id){

		Optional<PilotDTO> pilotDTO = pilotService.findById(id);

		if (pilotDTO.isPresent()){
			return ResponseEntity.ok(pilotDTO);
		} else {
			return ResponseEntity.noContent().build();
		}

	}

}

package com.atech.desafio.voos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.atech.desafio.voos.model.Pilot;
import com.atech.desafio.voos.model.transfer.PilotDTO;
import com.atech.desafio.voos.repository.PilotRepository;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Service
public class PilotService {

	@Setter
	private PilotRepository pilotRepository;

	public List<PilotDTO> findAll() {
		List<Pilot> pilots = pilotRepository.findAll();
		List<PilotDTO> pilotDTOs = new ArrayList<>();

		pilots.forEach(u -> pilotDTOs.add(mapToDTO(u)));

		return pilotDTOs;
	}

	public Optional<PilotDTO> findById(final Long id){
		final Optional<Pilot> pilot = pilotRepository.findById(id);
		return pilot.isPresent() ? Optional.of(mapToDTO(pilot.get())) : Optional.empty();
	}


    public PilotDTO mapToDTO(final Pilot pilot) {
    	final ModelMapper modelMapper = new ModelMapper();
    	return modelMapper.map(pilot, PilotDTO.class);
    }

    public Pilot mapFromDTO(final PilotDTO pilotDTO) {
    	final ModelMapper modelMapper = new ModelMapper();
    	return modelMapper.map(pilotDTO, Pilot.class);
    }

}

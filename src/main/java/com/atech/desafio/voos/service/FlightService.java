package com.atech.desafio.voos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.DateType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.atech.desafio.voos.model.Flight;
import com.atech.desafio.voos.model.filter.FlightFilter;
import com.atech.desafio.voos.model.transfer.FlightDTO;
import com.atech.desafio.voos.repository.FlightRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FlightService {

	private FlightRepository fightRepository;

	public List<FlightDTO> findByFilter(final FlightFilter flightFilter) {

		return fightRepository.findByFilter(flightFilter.getPilotName(),
											flightFilter.getPlaneModel(),
											flightFilter.getPlaneTailCode(),
											flightFilter.getCityDepart(),
											flightFilter.getCityArrive(),
											new TypedParameterValue(DateType.INSTANCE,flightFilter.getDepartTime()),
											new TypedParameterValue(DateType.INSTANCE,flightFilter.getArriveTime()),
											flightFilter.getStatusDescription()
											);

	}


	public List<FlightDTO> findAll() {
		List<Flight> flight = fightRepository.findAll();
		List<FlightDTO> fightDTOs = new ArrayList<>();

		flight.forEach(u -> fightDTOs.add(mapToDTO(u)));

		return fightDTOs;
	}

	public Optional<FlightDTO> findById(final Long id){
		final Optional<Flight> flight = fightRepository.findById(id);
		return flight.isPresent() ? Optional.of(mapToDTO(flight.get())) : Optional.empty();
	}


    public FlightDTO mapToDTO(final Flight fight) {
    	final ModelMapper modelMapper = new ModelMapper();
    	return modelMapper.map(fight, FlightDTO.class);
    }

    public Flight mapFromDTO(final FlightDTO flightDTO) {
    	final ModelMapper modelMapper = new ModelMapper();
    	return modelMapper.map(flightDTO, Flight.class);
    }
}

package com.atech.desafio.voos.model.transfer;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightDTO {

	private Long id;
	private String planeModel;
	private String planeTailCode;
	private String pilotName;
	private boolean pilotActive;
	private String cityDepart;
	private String cityArrive;
	private Date departTime;
	private Date arriveTime;
	private String statusDescription;

}

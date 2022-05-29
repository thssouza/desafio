package com.atech.desafio.voos.model.filter;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightFilter {

	private String pilotName;
	private String planeModel;
	private String planeTailCode;
	private String cityDepart;
	private String cityArrive;
	private Date departTime;
	private Date arriveTime;
	private String statusDescription;

}

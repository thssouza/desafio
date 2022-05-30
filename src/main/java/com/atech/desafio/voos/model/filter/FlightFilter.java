package com.atech.desafio.voos.model.filter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date departTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date arriveTime;
	private String statusDescription;

}

package com.atech.desafio.voos.model.transfer;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {

	private Long id;
	private String planeModel;
	private String planeTailCode;
	private String pilotName;
	private boolean pilotActive;
	private String cityDepart;
	private String cityArrive;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date departTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date arriveTime;
	private String statusDescription;

}

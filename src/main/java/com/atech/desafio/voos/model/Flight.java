package com.atech.desafio.voos.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="TB_PRODUCT_SUPPLIER")
@Data
public class Flight {

	@Id
	@Column(name = "FLID")
	@SequenceGenerator(name = "SEQ_TB_FLIGHT", sequenceName = "SEQ_TB_FLIGHT", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@JoinColumn(name = "FLPLANEID")
	@ManyToOne (fetch = FetchType.EAGER)
	private Plane plane;
	
	@NotNull
	@JoinColumn(name = "FLPILOTID")
	@ManyToOne (fetch = FetchType.EAGER)
	private Pilot pilot;
	
	@NotNull
	@JoinColumn(name = "FLDEPARTCITYID")
	@ManyToOne (fetch = FetchType.EAGER)
	private City cityDepart;	
	
	@NotNull
	@JoinColumn(name = "FLARRIVECITYID")
	@ManyToOne  (fetch = FetchType.EAGER)
	private City cityArrive;		
	
	@NotNull
	@Column(name = "FLDEPARTDATE")
	private Timestamp departTime;
	
	@NotNull
	@Column(name = "FLARRIVEDDATE")
	private Timestamp arriveTime;
	
	@NotNull
	@JoinColumn(name = "FLSTATUSID")
	@ManyToOne  (fetch = FetchType.EAGER)
	private Status status;
	
}

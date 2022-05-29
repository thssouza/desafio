package com.atech.desafio.voos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="TB_PLANE")
@Data
public class Plane {

	@Id
	@Column(name = "PNID")
	@SequenceGenerator(name = "SEQ_TB_PLANE", sequenceName = "SEQ_TB_PLANE", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "PNMODEL")
	private String model;

	@NotNull
	@Column(name = "PNIDENTCODE")
	private String tailCode;

}

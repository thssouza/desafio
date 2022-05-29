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
@Table(name="TB_PILOT")
@Data
public class Pilot {

	@Id
	@Column(name = "PLID")
	@SequenceGenerator(name = "SEQ_TB_PILOT", sequenceName = "SEQ_TB_PILOT", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "PLNAME")
	private String name;

	@Column(name = "PLACTIVE")
	private boolean active;

}

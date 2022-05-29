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
@Table(name="TB_CITY")
@Data
public class City {

	@Id
	@Column(name = "CIID")
	@SequenceGenerator(name = "SEQ_TB_CITY", sequenceName = "SEQ_TB_CITY", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "CINAME")
	private String city;

}

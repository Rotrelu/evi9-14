package com.example.bancortl1.springboot.app.models.entity;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table (name = "bancos")
@Entity
@Getter
@Setter
@ComponentScan
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	 @Column
	 @NotEmpty
	 private String nombre;

	 @Column
	 @NotEmpty
	 private String ubicacion;


}

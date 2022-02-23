package com.example.bancortl1.springboot.app.models.entity;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table (name = "bancos")
@Entity
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

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}

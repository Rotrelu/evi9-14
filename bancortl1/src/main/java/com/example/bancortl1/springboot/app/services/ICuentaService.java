package com.example.bancortl1.springboot.app.services;

import java.util.List;

import com.example.bancortl1.springboot.app.models.entity.Cuenta;

public interface ICuentaService {
	
	public Cuenta getByID(Long id, List<Cuenta> lista);

	

}

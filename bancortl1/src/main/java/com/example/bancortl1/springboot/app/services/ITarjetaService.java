package com.example.bancortl1.springboot.app.services;

import java.util.List;


import com.example.bancortl1.springboot.app.models.entity.Tarjeta;

public interface ITarjetaService {

	Tarjeta getByID(Long id, List<Tarjeta> lista);
	
}

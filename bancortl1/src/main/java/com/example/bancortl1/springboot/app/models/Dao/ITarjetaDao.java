package com.example.bancortl1.springboot.app.models.Dao;

import java.util.List;


import com.example.bancortl1.springboot.app.models.entity.Tarjeta;

public interface ITarjetaDao {
	
    List<Tarjeta> findAll();
	
    void save(Tarjeta tarjeta);
	
	Tarjeta findOne(Long id);
	
	void delete(Long id);

	Tarjeta findOne(String numerotarjeta);

}

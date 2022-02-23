package com.example.bancortl1.springboot.app.models.Dao;

import java.util.List;


import com.example.bancortl1.springboot.app.models.entity.Tarjeta;

public interface ITarjetaDao {
	
    public List<Tarjeta> findAll();
	
    public void save(Tarjeta tarjeta);
	
	public Tarjeta findOne(Long id);
	
	public void delete(Long id);

	public Tarjeta findOne(String numerotarjeta);

}

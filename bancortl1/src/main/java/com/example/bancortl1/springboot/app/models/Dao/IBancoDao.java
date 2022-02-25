package com.example.bancortl1.springboot.app.models.Dao;

import java.util.List;

import com.example.bancortl1.springboot.app.models.entity.Banco;

public interface IBancoDao {
	
	List<Banco> findAll();
	
	 void save(Banco banco);
		
	 Banco  findOne(Long id);
		
	 void delete(Long id);

}

package com.example.bancortl1.springboot.app.models.Dao;

import java.util.List;

import com.example.bancortl1.springboot.app.models.entity.Banco;

public interface IBancoDao {
	
	public List<Banco> findAll();
	
	 public void save(Banco banco);
		
	 public Banco  findOne(Long id);
		
	 public void delete(Long id);

}

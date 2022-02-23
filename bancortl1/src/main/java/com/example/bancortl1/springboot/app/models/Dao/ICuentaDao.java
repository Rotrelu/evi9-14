package com.example.bancortl1.springboot.app.models.Dao;

import java.util.List;
import com.example.bancortl1.springboot.app.models.entity.Cuenta;


public interface ICuentaDao {
	
	public List<Cuenta> findAll();
	
    public void save(Cuenta cliente);
	
	public Cuenta findOne(Long id);
	
	public void delete(Long id);
	
	

}

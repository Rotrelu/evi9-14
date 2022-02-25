package com.example.bancortl1.springboot.app.models.Dao;

import java.util.List;
import com.example.bancortl1.springboot.app.models.entity.Cuenta;


public interface ICuentaDao {
	
	List<Cuenta> findAll();
	
    void save(Cuenta cliente);
	
	Cuenta findOne(Long id);
	
	void delete(Long id);
	
	

}

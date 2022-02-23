package com.example.bancortl1.springboot.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bancortl1.springboot.app.models.Dao.ICuentaDao;
import com.example.bancortl1.springboot.app.services.ICuentaService;

@Component
public class CuentaPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private ICuentaService cuentaService;
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	
	
	@Override
	public void setAsText(String idStr) throws IllegalArgumentException {
		
		try {
			Long id = Long.parseLong(idStr);
			this.setValue(cuentaService.getByID(id,cuentaDao.findAll()));
		} catch (Exception e) {
			
		}
	}
	
	

}

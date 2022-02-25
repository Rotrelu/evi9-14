package com.example.bancortl1.springboot.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bancortl1.springboot.app.models.Dao.ICuentaDao;
import com.example.bancortl1.springboot.app.services.ICuentaService;

@Component
public class CuentaPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private  ICuentaService cuentaService;

	@Autowired
	private  ICuentaDao cuentaDao;

	public CuentaPropertyEditor(ICuentaDao cuentaDao, ICuentaService cuentaService) {
		this.cuentaDao = cuentaDao;
		this.cuentaService = cuentaService;
	}


	@Override
	public void setAsText(String idStr) throws IllegalArgumentException {
		
		try {
			Long id = Long.parseLong(idStr);
			this.setValue(cuentaService.getByID(id,cuentaDao.findAll()));
		} catch (Exception e) {
			System.out.println("hubo un error al asignar el objeto cuenta a la tarjeta");
			
		}
	}
	
	

}

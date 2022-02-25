package com.example.bancortl1.springboot.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.example.bancortl1.springboot.app.models.entity.Tarjeta;
@Component
public class TarjetaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Tarjeta.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		Tarjeta tarjeta = (Tarjeta) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.tarjeta.nombre");
		
		if (!tarjeta.getNumeroTarjeta().matches("[0-9]{10}")) {
			errors.rejectValue("nombre", "format.tarjeta.numerotarjeta");
		}
		
		if (!tarjeta.getNombre().matches("[a-z,A-Z]{1,15}?[ ]?[a-z,A-Z]{1,15}")) {
			errors.rejectValue("nombre", "format.tarjeta.nombre");
		}

	}

}

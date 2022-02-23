package com.example.bancortl1.springboot.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bancortl1.springboot.app.models.Dao.ICuentaDao;
import com.example.bancortl1.springboot.app.models.entity.Cuenta;


@Controller
public class CuentaController {
	
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String cuentaLista(Model model) {
		model.addAttribute("titulo","lista de cuentas");
		model.addAttribute("cuentas", cuentaDao.findAll());				
		return "lista";
	}
	@RequestMapping (value = "/form-cuenta")
	public String crear(Map<String, Object> model) {
		Cuenta cuenta = new Cuenta();
		model.put("tarjeta", cuenta);
		model.put("titulo", "Nueva cuenta, llenar datos");
		return "form-cuenta";
	}
	
	@RequestMapping (value = "/form-cuenta/{id}")
	public String editar (@PathVariable(value= "id")Long id, Map<String, Object>model) {
		Cuenta cuenta = null;
	if (id> 0) {
		cuenta = cuentaDao.findOne(id);
	}else{
		
		return "redirect:/lista";		
	}
	model.put("cuenta", cuenta);
	model.put("titulo", "Edite la cuenta");
	
	return"form-cuenta";
	
	}
	@RequestMapping(value = "form-cuenta", method = RequestMethod.POST)
	public String guardar(@Valid Cuenta cuenta, BindingResult result, Model model, SessionStatus status,
			RedirectAttributes flash) {

	

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario la cuenta");
			model.addAttribute("result", result.hasErrors());
			model.addAttribute("mensaje", "Error al registrar la cuenta");
			
			return "form-cuenta";
		} else {
			model.addAttribute("result", false);
			model.addAttribute("errList", "");
		}

		flash.addAttribute("completeMsj", "Se guardo correctamente");
		cuentaDao.save(cuenta);
		status.setComplete();

		return "redirect:form-cuenta";
	}

	public String elimiar(@PathVariable (value = "id")Long id ) {
		if(id > 0 ) {
			cuentaDao.delete(id);
		}
		return "redirect:index";
	}
		 	
}

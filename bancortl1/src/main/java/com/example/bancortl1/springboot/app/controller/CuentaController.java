package com.example.bancortl1.springboot.app.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.bancortl1.springboot.app.models.Dao.BancoDaoImpl;
import com.example.bancortl1.springboot.app.models.entity.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bancortl1.springboot.app.models.Dao.ICuentaDao;
import com.example.bancortl1.springboot.app.models.entity.Cuenta;
import com.example.bancortl1.springboot.app.validator.CuentaValidator;


@Controller
@SessionAttributes("cuenta")
public class CuentaController {
	
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	@Autowired
	private CuentaValidator cuentaValidator;

	@Autowired
	private BancoDaoImpl bancoDao;

	@GetMapping(value = "/lista-cuenta")
	public String cuentaLista(Model model) {
		model.addAttribute("titulo","lista de cuentas");
		model.addAttribute("cuentas", cuentaDao.findAll());				
		return "lista-cuenta";
	}

	@RequestMapping(value = "/form-cuenta")
	public String crear(Map<String, Object> model,Model modelList) {
		Cuenta cuenta = new Cuenta();
		model.put("titulo", "Nueva cuenta, llenar datos");
		model.put("cuenta", cuenta);
		List<Banco> listaBancos = bancoDao.findAll();
		modelList.addAttribute("listaBancos",listaBancos);

		return "form-cuenta";
	}
	
	@PutMapping (value = "/form-cuenta/{id}")
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
	public String guardar(@Valid Cuenta cuenta, BindingResult result, Model model,  SessionStatus status,
			RedirectAttributes flash) {
	            
		cuentaValidator.validate(cuenta, result);
		

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

 @DeleteMapping(value="/eliminarcuenta/{id}")
	public String elimiar(@PathVariable (value = "id")Long id ) {
		if(id > 0 ) {
			cuentaDao.delete(id);
		}
		return "redirect:/lista";
	}
		 	
}

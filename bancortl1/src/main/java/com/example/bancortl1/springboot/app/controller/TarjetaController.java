package com.example.bancortl1.springboot.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bancortl1.springboot.app.editors.CuentaPropertyEditor;
import com.example.bancortl1.springboot.app.models.Dao.ITarjetaDao;
import com.example.bancortl1.springboot.app.models.entity.Cuenta;
import com.example.bancortl1.springboot.app.models.entity.Tarjeta;

@Controller
@SessionAttributes("tarjeta")
public class TarjetaController {
	
	@Autowired
	private ITarjetaDao tarjetaDao;
	
	@Autowired
	private CuentaPropertyEditor cuentaEditor;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Cuenta.class, "cuenta", cuentaEditor);
		
		
	}
		
	@RequestMapping(value = "/lista-tarjeta", method = RequestMethod.GET)
	public String cuentaLista(Model model) {
		model.addAttribute("titulo","lista de tarjetas");
		model.addAttribute("tarjetas", tarjetaDao.findAll());				
		return "lista-tarjeta";
	}
	
	@RequestMapping(value = "/formtarjeta")
	public String crear(Map<String, Object> model, Model modelList) {
		Tarjeta tarjeta = new Tarjeta();
		model.put("tarjeta", tarjeta);
		return "formtarjeta";
	}
	
	@RequestMapping(value = "/formtarjeta/{id}")
	public String editar(@PathVariable (value = "id") Long id, Map<String, Object> model) {

		Tarjeta tarjeta = null;

		if (id != null && id > 0) {
			tarjeta = tarjetaDao.findOne(id);
		} else {
			return "index";
		}
		model.put("tarjeta", tarjeta);
		model.put("titulo", "Editar tarjeta");

		return "formtarjeta";
	
        }
	
	@RequestMapping(value = "/formtarjeta", method = RequestMethod.POST)
	public String guardar(@Valid Tarjeta tarjeta, BindingResult result, Model model, SessionStatus status,
			RedirectAttributes flash) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Llene correctamente los campos");
			model.addAttribute("result", result.hasErrors());
			model.addAttribute("mesnsaje","Error en los datos , intente nuvenamete");
			return "formtarjeta";
		} else {
			model.addAttribute("resul", false);
	           }
		model.addAttribute("titulo","Formulariop de tarjeta");
		model.addAttribute("mensaje","Informacion recivida");
		try {
			tarjetaDao.save(tarjeta);
		} catch (Exception e) {
			
		}
		status.setComplete();
		return "redirect:formtarjeta";
        }	
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {

		if (id != null && id > 0) {
			tarjetaDao.delete(id);
		}
		return "redirect:/tarjetas-lista";
	
	}
}	


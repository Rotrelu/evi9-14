package com.example.bancortl1.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bancortl1.springboot.app.models.Dao.IBancoDao;

@Controller
public class BancoController {
	
	@Autowired
	private IBancoDao bancoDao;
	
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String cuentaLista(Model model) {
		model.addAttribute("titulo","lista de bancos");
		model.addAttribute("bancos", bancoDao.findAll());
				
		return "lista";
	}

}

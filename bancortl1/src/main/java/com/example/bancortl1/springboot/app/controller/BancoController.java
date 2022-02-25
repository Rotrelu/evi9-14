package com.example.bancortl1.springboot.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.bancortl1.springboot.app.models.Dao.IBancoDao;
import com.example.bancortl1.springboot.app.models.entity.Banco;



@Controller
@SessionAttributes("banco")
public class BancoController {
	
	@Autowired
	private IBancoDao bancoDao;
	
	
	@GetMapping(value = "/lista-banco")
	public String cuentaLista(Model model) {
		model.addAttribute("titulo","lista de bancos");
		model.addAttribute("bancos", bancoDao.findAll());
				
		return "lista-banco";
	
	}
	
	@RequestMapping (value = "/form-banco")
	public String crear(Map<String, Object> model) {
		Banco banco = new Banco();
		model.put("banco", banco);
		model.put("titulo", "Nuevo Banco, llenar datos");
		return "form-banco";
	}
	
	@PutMapping (value = "/form-banco/{id}")
	public String editar (@PathVariable(value= "id")Long id, Map<String, Object>model) {
		Banco banco = null;
		if (id> 0) {
			banco = bancoDao.findOne(id);
		}else{

			return "redirect:/lista";
		}
		model.put("banco", banco);
		model.put("titulo", "Edite su banco");
		return "form-banco/{id}";
	}	
	
	@DeleteMapping(value="/eliminarbanco/{id}")
	public String elimiar(@PathVariable (value = "id")Long id ) {
		if(id > 0 ) {
			bancoDao.delete(id);
		}
		return "redirect:/lista";
	}

	@RequestMapping(value = "/guardar")
	public void guardarBanco(Banco model){
		bancoDao.save(model);
	}
}

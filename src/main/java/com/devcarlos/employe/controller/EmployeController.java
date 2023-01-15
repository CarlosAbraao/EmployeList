package com.devcarlos.employe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devcarlos.employe.entities.Employe;
import com.devcarlos.employe.service.EmployeService;



@Controller
public class EmployeController {
	
	
	@Autowired
	private EmployeService employeService;
	
	// Visualizar LIST
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		model.addAttribute("listEmploye", employeService.getAllEmploye());
		
		return "index";
		
		
	}
	
	@GetMapping("/showNewEmployeForm")
	public String showNewEmployeForm(Model model) {
		Employe employe = new Employe();
		
		model.addAttribute("employe", employe);
		
		return "new_employe";
		
		
	}
	
	@PostMapping("/salvaEmpregado")
	public String saveEmploye(@ModelAttribute("employe") Employe employe) {
		employeService.saveEmploye(employe);
		return "redirect:/";
	}

}

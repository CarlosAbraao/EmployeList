package com.devcarlos.employe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}

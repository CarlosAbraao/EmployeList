package com.devcarlos.employe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/saveEmploye")
	public String saveEmploye(@ModelAttribute("employe") Employe employe) {
		employeService.saveEmploye(employe);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value="id") long id, Model model ) {
		 
		Employe employe = employeService.getEmployeById(id);
		
		
		model.addAttribute("employe",employe);
		 
		
		return  "update_employe";
		
		
	}
	
	
	@GetMapping("/deleteEmploye/{id}")
	public String deleteEmploye(@PathVariable(value = "id") long id) {
		this.employeService.deleteEmployeByid(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value= "pageNo") int pageNo, Model model) {
		int pageSize = 5 ;
		
		Page <Employe> page = employeService.findPaginated(pageNo, pageSize);
		List<Employe> listEmployes = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listEmploye", listEmployes);
		return "index";
		
		
	}

}

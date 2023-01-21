package com.devcarlos.employe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devcarlos.employe.entities.Employe;

@Service
public interface EmployeService {
	
	
	public List<Employe> getAllEmploye();
	void saveEmploye(Employe employe);
	Employe getEmployeById(long id);
	

}

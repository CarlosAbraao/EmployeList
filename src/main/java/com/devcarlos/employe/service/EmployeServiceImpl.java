package com.devcarlos.employe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcarlos.employe.entities.Employe;
import com.devcarlos.employe.repository.EmployeRepository;


@Service
public class EmployeServiceImpl implements EmployeService{
		
		
	@Autowired
	private EmployeRepository employeServiceImpl;

	@Override
	public List<Employe> getAllEmploye() {
		// TODO Auto-generated method stub
		return employeServiceImpl.findAll();
	}

	@Override
	public void saveEmploye(Employe employe) {
		this.employeServiceImpl.save(employe);
		
	}
	
	
}

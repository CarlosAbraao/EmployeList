package com.devcarlos.employe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcarlos.employe.entities.Employe;
import com.devcarlos.employe.repository.EmployeRepository;


@Service
public class EmployeServiceImpl implements EmployeService{
		
		
	@Autowired
	private EmployeRepository employeRepository;
	
	

	@Override
	public List<Employe> getAllEmploye() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

	@Override
	public void saveEmploye(Employe employe) {
		this.employeRepository.save(employe);
		
	}

	@Override
	public Employe getEmployeById(long id) {
		Optional<Employe> optional = employeRepository.findById(id);
		Employe employe = null;
		if(optional.isPresent()){
			
			employe = optional.get();
			
		}else {
			throw new RuntimeException("Funcionario não encontrado" + id  );
		}
		  
		
		return employe;
	}

	@Override
	public void deleteEmployeByid(long id) {
		this.employeRepository.deleteById(id);
		
	}
	
	
}

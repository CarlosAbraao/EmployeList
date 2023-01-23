package com.devcarlos.employe.service;

import com.devcarlos.employe.dto.UserRegistrationDto;
import com.devcarlos.employe.entities.User;

public interface UserService {
	
	User save(UserRegistrationDto registrationDto);
	
	
	

}

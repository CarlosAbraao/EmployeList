package com.devcarlos.employe.service;





import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcarlos.employe.dto.UserRegistrationDto;
import com.devcarlos.employe.entities.Role;
import com.devcarlos.employe.entities.User;
import com.devcarlos.employe.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(),
								registrationDto.getEmail(),registrationDto.getPassword(),
								Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}

	

}

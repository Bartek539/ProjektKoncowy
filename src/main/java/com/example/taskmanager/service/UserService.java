package com.example.taskmanager.service;

import com.example.taskmanager.model.User;
import com.example.taskmanager.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	User findUserByEmail(String email);
}

package com.pablotelles.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablotelles.springsecurity.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserRepository userRepository;
	
	public UserController(final UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
}

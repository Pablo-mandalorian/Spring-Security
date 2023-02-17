package com.pablotelles.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pablotelles.springsecurity.model.User;
import com.pablotelles.springsecurity.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private final UserRepository userRepository;
	
	public UserDetailsServiceImpl(final UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository
				.findOneByEmail(email)
				.orElseThrow(()-> new UsernameNotFoundException(email+" no existe"));
		
		
		return null;
	}

}

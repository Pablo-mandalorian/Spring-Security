package com.pablotelles.springsecurity.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) throws AuthenticationException{
		
		AuthCredentials authCredentials = new AuthCredentials();
		
		try {
			authCredentials  = new ObjectMapper().readValue(httpServletRequest.getReader(), AuthCredentials.class);
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				authCredentials.getEmail(),
				authCredentials.getPassword(), 
				Collections.emptyList()
				);
				
		
		return getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
		
	}
	
	@Override
	protected void successfulAuthentication(
			HttpServletRequest request,
			HttpServletResponse response, 
			FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		UserDetailsImpl userDetailsImpl =(UserDetailsImpl) authResult.getPrincipal();
		String token = TokenUtils.createToken(userDetailsImpl.getName(), userDetailsImpl.getUsername());

		response.addHeader("Authorization", "Bearer " + token);
		response.getWriter().flush();

		super.successfulAuthentication(request, response, chain, authResult);
	}
	
}

package com.pablotelles.springsecurity.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
	
	private final static String ACCESS_TOKEN_SECRET = "7638792F423F4528482B4D6251655368566D597133743677397A24432646294A";
	private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 86_400L;
	
	
	
	//Create the Token
	public static String createToken(String nombre, String email){
		long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
		Date expirationDate = new Date(System.currentTimeMillis()+expirationTime);
		
		Map<String, Object> extra = new HashMap<>();
		extra.put("nombre", nombre);
		
		return Jwts.builder()
				.setSubject(email)
				.setExpiration(expirationDate)
				.addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
				.compact();
	}
	
	//Authentication
	public static UsernamePasswordAuthenticationToken getAuthentication(String token)throws Exception{
		Claims claims = Jwts.parserBuilder()
						.setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
						.build()
						.parseClaimsJws(token)
						.getBody();
		
		String email = claims.getSubject();
		
		return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
				
	}
	
	
}

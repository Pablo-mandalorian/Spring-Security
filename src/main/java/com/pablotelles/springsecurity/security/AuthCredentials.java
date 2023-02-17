package com.pablotelles.springsecurity.security;

import java.util.Objects;

import lombok.Data;

@Data
public class AuthCredentials {

	private String email;
	private String password;
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthCredentials other = (AuthCredentials) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}
	/**
	 * @param email
	 * @param password
	 */
	public AuthCredentials(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	
	
	
}

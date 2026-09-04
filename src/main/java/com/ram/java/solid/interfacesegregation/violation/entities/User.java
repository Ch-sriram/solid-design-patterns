package com.ram.java.solid.interfacesegregation.violation.entities;

import java.time.LocalDateTime;

/**
 * User entity that represents a User model with user details
 */
public class User extends Entity {
	
	private String name;

	private LocalDateTime lastLogin;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastLogin
	 */
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
}

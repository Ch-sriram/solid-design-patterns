package com.ram.java.designpatterns.builder.traditional;

import com.ram.java.designpatterns.builder.User;

/**
 * Represents the contract for how any DTO
 * related to {@link User} should behave.
 */
public interface UserDTO {

	String getName();

	String getAddress();

	String getAge();
}

package com.ram.java.designpatterns.builder;

/**
 * Represents the contract for how any DTO
 * related to {@link User} should behave.
 */
public interface UserDTO {

	String getName();

	String getAddress();

	String getAge();
}

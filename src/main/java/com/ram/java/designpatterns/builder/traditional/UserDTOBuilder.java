package com.ram.java.designpatterns.builder.traditional;

import java.time.LocalDate;

import com.ram.java.designpatterns.builder.Address;
import com.ram.java.designpatterns.builder.UserDTO;

/**
 * Defines the behaviour for builders that need
 * to build any object related to {@link UserDTO}.
 */
public interface UserDTOBuilder {
	// 1. Identify the "parts" of the class you want to build builder for,
	// and provide methods to create methods for those "parts".
	UserDTOBuilder withFirstName(String firstName);
	UserDTOBuilder withLastName(String lastName);
	UserDTOBuilder withAddress(Address address);
	UserDTOBuilder withBirthday(LocalDate birthday);

	// 2. Provide a method to "assemble" of build the final object.
	UserDTO build();

	// 3. The builder must provide a way/method to get the fully built object out.
	UserDTO getUserDTO();
}

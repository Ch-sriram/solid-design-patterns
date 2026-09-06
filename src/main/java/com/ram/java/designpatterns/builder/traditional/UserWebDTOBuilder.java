package com.ram.java.designpatterns.builder.traditional;

import java.time.LocalDate;
import java.time.Period;

import com.ram.java.designpatterns.builder.Address;
import com.ram.java.designpatterns.builder.UserDTO;
import com.ram.java.designpatterns.builder.UserWebDTO;

/**
 * The concrete builder for {@link UserDTOBuilder}.
 */
public class UserWebDTOBuilder implements UserDTOBuilder {
	private String firstName;
	private String lastName;
	private String age;
	private String address;
	private UserWebDTO dto;

	@Override
	public UserDTOBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	@Override
	public UserDTOBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	@Override
	public UserDTOBuilder withAddress(Address address) {
		this.address = address.getHouseNumber() + ", " + address.getStreet() + "\n" +
					   address.getCity() + "\n" + address.getState() + " - " + address.getZipCode();
		return this;
	}

	@Override
	public UserDTOBuilder withBirthday(LocalDate birthday) {
		Period ageInYears = Period.between(birthday, LocalDate.now());
		this.age = Integer.toString(ageInYears.getYears());
		return this;
	}

	@Override
	public UserDTO build() {
		return (dto = new UserWebDTO(firstName + " " + lastName, address, age));
	}

	@Override
	public UserDTO getUserDTO() {
		return dto;
	}

}

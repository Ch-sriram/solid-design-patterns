package com.ram.java.designpatterns.builder.traditional;

import java.time.LocalDate;

import com.ram.java.designpatterns.builder.Address;
import com.ram.java.designpatterns.builder.User;
import com.ram.java.designpatterns.builder.UserDTO;

/**
 * Director/Driver program that creates and controls
 * {@link UserDTO} related object(s) via
 * {@link UserDTOBuilder}. 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = createUser();
		UserDTOBuilder builder = new UserWebDTOBuilder();
		UserDTO userDTO = directBuild(builder, user);
		System.out.println(userDTO);
	}

	/**
	 * Directs the building of the {@link UserDTO} object using
	 * a {@link UserDTOBuilder} object.
	 *
	 * @param builder
	 * @param user
	 * @return
	 */
	private static UserDTO directBuild(UserDTOBuilder builder, User user) {
		return builder.withFirstName(user.getFirstName())
                      .withLastName(user.getLastName())
                      .withBirthday(user.getBirthday())
                      .withAddress(user.getAddress())
                      .build();
	}

	/**
	 * Creates a sample user
	 * @return
	 */
	public static User createUser() {
		Address address = new Address();
		address.setHouseNumber("1-1-365/A/1, D-502");
		address.setStreet("Siddamsetty Towers, Jawaharnagar, RTC X Roads");
		address.setCity("Hyderabad");
		address.setState("Telangana");
		address.setZipCode("500020");

		User user = new User();
		user.setFirstName("Sriram");
		user.setLastName("Chandrabhatta");
		user.setBirthday(LocalDate.of(1995, 4, 10));
		user.setAddress(address);

		return user;
	}
}

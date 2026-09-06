package com.ram.java.designpatterns.builder.modernrealworld;

import java.time.LocalDate;

import com.ram.java.designpatterns.builder.Address;
import com.ram.java.designpatterns.builder.User;
import com.ram.java.designpatterns.builder.modernrealworld.UserDTO.UserDTOBuilder;

/**
 * Demonstrates the workings of Builder design pattern
 * using {@link UserDTOBuilder} via {@link UserDTO},
 * and {@link User} object(s).
 */
public class ClientBuilder {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = createUser();
		UserDTO userDTO = directBuild(UserDTO.getBuilder(), user);
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

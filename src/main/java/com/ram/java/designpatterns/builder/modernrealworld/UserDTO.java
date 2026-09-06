/**
 * 
 */
package com.ram.java.designpatterns.builder.modernrealworld;

import java.time.LocalDate;
import java.time.Period;

import com.ram.java.designpatterns.builder.Address;
import com.ram.java.designpatterns.builder.User;

/**
 * Represents {@link User} object as a DTO.
 *
 * This class also contains a Builder implementation
 * for easier handling of the DTO from {@link User}.
 *
 * @implNote Builder pattern is usually implemented
 * as a public static class inside the class for
 * which the instance is to be built. In this case,
 * {@link UserDTO} itself will have a
 * {@code UserDTOBuilder} static class, which can
 * be utilized to build this object. 
 */
public class UserDTO {
	private String name;

	private String age;

	private String address;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * @param age the age to set
	 */
	private void setAge(String age) {
		this.age = age;
	}

	/**
	 * @param address the address to set
	 */
	private void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	/**
	 * Get's a new instance of the builder for {@link UserDTO} object.
	 * 
	 * @apiNote this is sometimes optional, since inner public static classes
	 * can be created using `new UserDTO.UserDTOBuilder()`
	 * 
	 * @return
	 */
	public static UserDTOBuilder getBuilder() {
		return new UserDTOBuilder();
	}

	/**
	 * Builder for {@link UserDTO} object (defined within this same class)
	 */
	public static class UserDTOBuilder {
		private String firstName;
		private String lastName;
		private String address;
		private String age;
		private UserDTO userDto;

		public UserDTOBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserDTOBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserDTOBuilder withAddress(Address address) {
			this.address = address.getHouseNumber() + ", " + address.getStreet() + "\n" +
					       address.getCity() + "\n" + address.getState() + " - " + address.getZipCode();
			return this;
		}

		public UserDTOBuilder withBirthday(LocalDate birthday) {
			this.age = Integer.toString(Period.between(birthday, LocalDate.now()).getYears());
			return this;
		}

		public UserDTO build() {
			UserDTO dto = new UserDTO();
			
			// Since this class is an Inner Static class, the class can even make use of
			// private setter methods of UserDTO class, which is a really neat trick
			// to NOT expose the setters to any upstream/downstream API, or any client,
			// all while being able to use it inside the inner static class.
			dto.setName(firstName + " " + lastName);
			dto.setAddress(address);
			dto.setAge(age);
			return (userDto = dto);
		}

		public UserDTO getUserDTO() {
			return userDto;
		}
	}
}

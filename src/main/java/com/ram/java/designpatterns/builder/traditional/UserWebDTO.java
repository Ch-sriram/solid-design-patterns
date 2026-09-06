package com.ram.java.designpatterns.builder.traditional;

/**
 * Represents a concrete implementation of
 * {@link UserDTO} object. 
 */
public class UserWebDTO implements UserDTO {
	
	private String name;

	private String address;

	private String age;

	public UserWebDTO(String name, String address, String age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	@Override
	public String getAddress() {
		return address;
	}

	/**
	 * @return the age
	 */
	@Override
	public String getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "UserWebDTO [name=" + name + ", address=" + address + ", age=" + age + "]";
	}
}

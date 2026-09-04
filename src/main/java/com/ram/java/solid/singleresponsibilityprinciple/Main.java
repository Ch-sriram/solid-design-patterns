package com.ram.java.solid.singleresponsibilityprinciple;

import java.util.List;
import java.io.IOException;

/**
 * This class is used for testing out {@code UserController}.
 */
public class Main {
	private static final String RESPONSE_SUCCESS = "SUCCESS";
	private static final String RESPONSE_ERROR = "ERROR";
	
	private static final String VALID_USER_JSON = "{\"name\": \"Randy\", \"email\": \"randy@email.com\", \"address\":\"110 Sugar lane\"}";
	private static final String INVALID_USER_JSON = "{\"name\": \"Sam\", \"email\": \"sam@email\", \"address\":\"111 Sugar lane\"}";
	private static final String INVALID_USER_JSON_2 = "{\"name\": \"Randy\", \"email\": \"randy@email.com\", \"address\":\"110 Sugar lane\"}";

	public static void main(String[] args) {
		UserController controller = new UserController();

		List.of(VALID_USER_JSON, INVALID_USER_JSON, INVALID_USER_JSON_2)
			.forEach(json -> {
				System.out.println("Converting User JSON: " + json);
				String response = null;
				try {
					response = controller.createUser(json);
				} catch (IOException e) {
					System.err.println("Error: Creating User from Given JSON: " + json);
					e.printStackTrace();
				}

				if (response.equalsIgnoreCase(RESPONSE_ERROR)) {
					System.err.println("Failed!");
					System.out.println("Invalid JSON response received: " + response);
				}

				if (response.equalsIgnoreCase(RESPONSE_SUCCESS)) {
					System.out.println("Pass!");
					System.out.println("Valid JSON response received: " + response);
				}

				if (!response.equalsIgnoreCase(RESPONSE_SUCCESS) && !response.equalsIgnoreCase(RESPONSE_ERROR)) {
					throw new RuntimeException("Something went wrong when creating a new user!");
				}

				System.out.println("-------------------------------------------\n");
			});
	}
}

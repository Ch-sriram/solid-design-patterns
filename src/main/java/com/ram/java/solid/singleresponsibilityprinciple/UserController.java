package com.ram.java.solid.singleresponsibilityprinciple;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

// Handles incoming JSON requests that work on User
public class UserController {

	private UserPersistenceService persistenceService = (UserPersistenceService) UserServiceFactory.getService(UserServiceFactory.Services.PERSISTENCE);

	// This method in UserController doesn't violate Single Responsibility Principle.
	public String createUser(String userJSON) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userJSON, User.class);

		UserValidator validator = new UserValidator();
		if (!validator.validateUser(user)) { // Validation is being handled by UserValidator, instead of UserController
			return "ERROR";
		}

		persistenceService.saveUser(user); 	 // Persistence of the User object is being handled by UserPersistenceService, instead of UserController.s
		return "SUCCESS";
	}


	/**
	 * SRP VIOLATIONS FOLLOW BELOW.
	 * Although, the code below works, but it's hard to read, refactor, and maintain in the long run.
	 */
	
	// SRP Violation - 1:
	private static Store store = new Store(); // This shouldn't be created at the controller layer, controllers shouldn't be responsible for creating a Store object.
	
	/**
	 * UserController can have its own methods, but they must not do everything in the controller.
	 * For example, the below createUser is a really bad way to write a controller method.
	 */
	
	// SRP Violation - 2: Create User method in this case is handling user validation, and storing to the store.
	public String createUserViolatingSRP(String userJson) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(userJson, User.class);

		if (!isValidUser(user)) { // The method related to isValidUser can be taken out into a class called UserValidator
			return "ERROR";
		}

		// The persistence of user can be taken into a separate service called UserPersistenceService
		store.store(user);
		return "SUCCESS";
	}

	// SRP Violation - 3: Code for user validation is being implemented and maintained by the controller, which shouldn't be the responsibility of the UserController 
	private static boolean isValidUser(User user) {
		// 1. Check if the given User object is null or not.
		if (Objects.isNull(user)) return false;

		// 2. Check if the userName or userEmail is null or empty
		if (isNullOrEmpty(user.getName()) || isNullOrEmpty(user.getEmail())) return false;
		user.setName(user.getName().trim());
		user.setEmail(user.getEmail().trim());

		// 3. Check if the user is already present in the Store, if present, return true.
		if (isAlreadyPresentInStore(user)) {
			try {
				throw new RuntimeException("User already exists in Store");
			} catch (RuntimeException e) {
				e.printStackTrace();
			}

			return false;
		}

		// 2. Check if the given user's name is a valid user-name: Alpha-numeric values are allowed.
		if (!isValidAlphaNumeric(user.getName())) {
			return false;
		}

		// 3. Check if the user's email is valid or not.
		if (!isValidEmail(user.getEmail())) {
			return false;
		}

		return true;
	}

	// SRP Violation - 4: UserController shouldn't be responsible for checking whether the given user's name is null/empty.
	private static boolean isNullOrEmpty(String userName) {
		return Objects.isNull(userName) || userName.length() == 0; 
	}

	// SRP Violation - 5: UserController shouldn't be responsible for checking whether the given user is present in the data store or not.
	private static boolean isAlreadyPresentInStore(User user) {
		if (Objects.isNull(user)) {
			throw new RuntimeException("Invalid User (null) Object");
		}

		return !Objects.isNull(store.getUser(user.getName()));
	}
	
	// SRP Violation - 6: UserController shouldn't be responsible for checking whether the given user name is alphanumeric or not.
	private static boolean isValidAlphaNumeric(String userName) {
		Pattern pattern = Pattern.compile("^[A-Za-z][A-Za-z0-9]+$");
		Matcher matcher = pattern.matcher(userName);
		return matcher.find();
	}
	
	// SRP Violation - 7: UserController shouldn't be responsible for checking whether the given user email is valid or not.
	private static boolean isValidEmail(String userEmail) {
		Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher emailMatcher = emailPattern.matcher(userEmail);
		return emailMatcher.find();
	}
	
	// SRP Violations from 3-7 can be maintained in a single class called UserValidator, which would ideally just exposes a single public API like: validateUser,
	// and all other validation related code can be private to the UserValidator class.
}

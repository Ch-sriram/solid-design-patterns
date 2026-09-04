package com.ram.java.solid.singleresponsibilityprinciple;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles validation of {@link User} details.
 */
public class UserValidator {
	
	private static final UserPersistenceService userPersistenceService = (UserPersistenceService) UserServiceFactory.getService(UserServiceFactory.Services.PERSISTENCE); 
	
	public boolean validateUser(User user) {
		return isValidUser(user);
	}

	/**
	 * Validates the given User object
	 * @param user the user object
	 * @return {@code true} if the given {@link User} object is valid, otherwise {@link false}
	 */
	private boolean isValidUser(User user) {
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

	private boolean isNullOrEmpty(String userName) {
		return Objects.isNull(userName) || userName.length() == 0; 
	}

	private boolean isAlreadyPresentInStore(User user) {
		return userPersistenceService.isUserInStore(user);
	}
	
	private boolean isValidAlphaNumeric(String userName) {
		Pattern pattern = Pattern.compile("^[A-Za-z][A-Za-z0-9]+$");
		Matcher matcher = pattern.matcher(userName);
		return matcher.find();
	}
	
	private boolean isValidEmail(String userEmail) {
		Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher emailMatcher = emailPattern.matcher(userEmail);
		return emailMatcher.find();
	}

}

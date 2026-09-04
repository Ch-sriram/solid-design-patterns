package com.ram.java.solid.singleresponsibilityprinciple;

import java.util.Objects;

/**
 * A separate class for handling persistence of User details
 * into the {@code Store}. 
 */
public class UserPersistenceService implements UserService {

	private Store store = new Store();
	
	public void saveUser(User user) {
		store.store(user);
	}
	
	public boolean isUserInStore(User user) throws RuntimeException {
		if (Objects.isNull(user)) {
			throw new RuntimeException("Invalid User (null) Object");
		}
		
		return !Objects.isNull(store.getUser(user.getName()));
	}
}

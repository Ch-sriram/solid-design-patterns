package com.ram.java.solid.singleresponsibilityprinciple;

/**
 * Factory that gets any class related to
 * {@link UserService} interface.
 */
public class UserServiceFactory {
	private static UserPersistenceService userPersistenceService = null;

	public static UserService getService(UserService service) {
		if (service instanceof UserPersistenceService) {
			if (userPersistenceService == null) {
				userPersistenceService = (UserPersistenceService) service;
			}
			return userPersistenceService;
		}

		return null;
	}
	
	public static UserService getService(Services service) {
		switch(service) {
			case PERSISTENCE:
				return userPersistenceService != null ? userPersistenceService : (userPersistenceService = new UserPersistenceService());
			default:
				throw new RuntimeException("Invalid Service");
		}
	}

	public static enum Services {
		PERSISTENCE
	}
}

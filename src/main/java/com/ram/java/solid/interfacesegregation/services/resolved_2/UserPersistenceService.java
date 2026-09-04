package com.ram.java.solid.interfacesegregation.services.resolved_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ram.java.solid.interfacesegregation.entities.User;

// Implementing another behaviour for finding the details of the User by name,
// using PersistenceByNameService, gives a flexible way to make use of interfaces.
// Now, there are no errors, and UserPersistenceService is also enforced to implement
// findByName method, without making the enforcement compulsory for OrderPersistenceService.
public class UserPersistenceService implements PersistenceService<User>, PersistenceByNameService<User> {
	
	private static final Map<Long, User> USERS = new HashMap<>();

	@Override
	public void save(User entity) {
		synchronized(USERS) {
			USERS.put(entity.getId(), entity);
		}
	}

	@Override
	public void delete(User entity) {
		synchronized(USERS) {
			USERS.remove(entity.getId());
		}
	}

	@Override
	public User findById(long id) {
		synchronized(USERS) {
			return USERS.get(id);
		}
	}

	@Override
	public List<User> findByName(String name) {
		synchronized(USERS) {
			return USERS.values().stream().filter(user -> user.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		}
	}
}

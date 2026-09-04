package com.ram.java.solid.interfacesegregation.services.resolved_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ram.java.solid.interfacesegregation.entities.User;

public class UserPersistenceService implements PersistenceService<User> {
	
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

	// This class still can implement findByName, only thing is that it's
	// no longer Overriding findByName, it's defining its own class method(s).
	public List<User> findByName(String name) {
		synchronized(USERS) {
			return USERS.values().stream().filter(user -> user.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		}
	}
}

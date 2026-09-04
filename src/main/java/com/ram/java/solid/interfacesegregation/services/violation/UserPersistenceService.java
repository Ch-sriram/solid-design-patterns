package com.ram.java.solid.interfacesegregation.services.violation;

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

	@Override
	public List<User> findByName(String name) {
		synchronized(USERS) {
			return USERS.values().stream().filter(user -> user.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		}
	}
}

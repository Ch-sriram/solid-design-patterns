package com.ram.java.solid.singleresponsibilityprinciple;

import java.util.HashMap;
import java.util.Map;

/**
 * Simulates a call to storing data inside
 * either a Database, or a Caching layer like
 * Memcached/Redis.
 */
public class Store {
	
	private static final Map<String, User> STORAGE = new HashMap<>();
	
	public void store(User user) {
		synchronized(STORAGE) {
			// User::name is a flimsy database storage identifier, but for this example, it suffices.
			STORAGE.put(user.getName(), user);
		}
	}
	
	public User getUser(String name) {
		synchronized(STORAGE) {
			return STORAGE.get(name);
		}
	}
}

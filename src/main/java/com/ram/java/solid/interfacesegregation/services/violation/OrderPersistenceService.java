package com.ram.java.solid.interfacesegregation.services.violation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ram.java.solid.interfacesegregation.entities.Order;

public class OrderPersistenceService implements PersistenceService<Order> {
	
	private static Map<Long, Order> ORDERS = new HashMap<>();

	@Override
	public void save(Order entity) {
		synchronized (ORDERS) {
			ORDERS.put(entity.getId(), entity);
		}
	}

	@Override
	public void delete(Order entity) {
		synchronized (ORDERS) {
			ORDERS.remove(entity.getId());
		}
	}

	@Override
	public Order findById(long id) {
		synchronized (ORDERS) {
			return ORDERS.get(id);
		}
	}

	@Override
	public List<Order> findByName(String name) { // This here, is a problematic implementation of a behaviour which doesn't make sense for OrderPersistenceService class.
		// This implementation is the main reason why too large interfaces should be segregated into smaller interfaces, that can be used optionally.
		throw new UnsupportedOperationException("Find by name operation for Orders, not supported!");
	}
}

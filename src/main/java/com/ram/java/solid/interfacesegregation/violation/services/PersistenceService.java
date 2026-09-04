package com.ram.java.solid.interfacesegregation.violation.services;

import java.util.List;

import com.ram.java.solid.interfacesegregation.violation.entities.Entity;

/**
 * Common interface to be implemented by all services that persist data into memory/disk.
 * @param <T> type/sub-type of {@link Entity}
 */
public interface PersistenceService<T extends Entity> {
	
	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(long id);

	// This behaviour is assuming that even OrderPersistenceService will implement the findByName API,
	// whereas, it cannot, since there's no field called `name` in Order entity.
	public List<T> findByName(String name);

}

package com.ram.java.solid.interfacesegregation.services.resolved_2;

import com.ram.java.solid.interfacesegregation.entities.Entity;

/**
 * Common interface to be implemented by all services that persist data into memory/disk.
 * @param <T> type/sub-type of {@link Entity}
 */
public interface PersistenceService<T extends Entity> {
	
	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(long id);

	// Get rid of findByName behaviour from PersistenceService completely.
//	public List<T> findByName(String name);

}

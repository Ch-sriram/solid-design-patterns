package com.ram.java.solid.interfacesegregation.services.resolved_1;

import com.ram.java.solid.interfacesegregation.entities.Entity;

/**
 * Common interface to be implemented by all services that persist data into memory/disk.
 * @param <T> type/sub-type of {@link Entity}
 */
public interface PersistenceService<T extends Entity> {
	
	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(long id);

	// One way is to remove the problem causing interface completely, and only the sub-class
	// that wants to implement its version of findByName, may do so, without any interface behaviour defining contracts
//	public List<T> findByName(String name);

}

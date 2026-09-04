package com.ram.java.solid.interfacesegregation.services.resolved_2;

import java.util.List;

import com.ram.java.solid.interfacesegregation.entities.Entity;

/**
 * Service that defines behaviour for persisting via name fields 
 */
public interface PersistenceByNameService<T extends Entity> {

	public List<T> findByName(String name);

}

package com.ram.java.solid.interfacesegregation.violation.entities;

/**
 * Base class for all entities in the current entities package 
 */
public abstract class Entity {
	
	private long id;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

}

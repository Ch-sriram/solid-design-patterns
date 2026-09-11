package com.ram.java.designpatterns.abstractfactory.example1;

/**
 * Represents a Storage resource for a compute {@link Instance}.
 *
 * @apiNote Abstract Product
 */
public interface Storage {

	/**
	 * Gets the identifier for storage resource.
	 * @return
	 */
	String getId();
}

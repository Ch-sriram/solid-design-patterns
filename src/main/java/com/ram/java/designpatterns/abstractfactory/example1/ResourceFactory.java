package com.ram.java.designpatterns.abstractfactory.example1;

import com.ram.java.designpatterns.abstractfactory.example1.Instance.Capacity;

/**
 * Represents a Resource for any cloud provider.
 *
 * @apiNote Abstract Factory with methods defined for each object type
 */
public interface ResourceFactory {
	/**
	 * Creates a compute engine instance.
	 *
	 * @param capacity small, medium, or large
	 * @return
	 */
	Instance createInstance(Capacity capacity);

	/**
	 * Creates a storage resource, given the capacity of storage in Mibs.
	 *
	 * @param capacityInMib size of the storage in MiB
	 * @return
	 */
	Storage createStorage(int capacityInMib);
}

package com.ram.java.designpatterns.singleton.lazysingleton.singletonenumimpl;

/**
 * (Refer: Google I/O 2008 Joshua Bloch's Presentation)
 * Since JMM 1.5, using Enums, we can create a Singleton.
 * It handles serialization using Java's Inbuilt mechanism
 * and still ensures a single instance. 
 */
public enum RegistryEnum {

	INSTANCE;

	public static RegistryEnum getInstance() {
		return INSTANCE;
	}

	/**
	 * Having enum as a singleton object takes care of a few things:
	 *
	 * 1. Enums cannot be inherited.
	 * 2. You cannot create objects of Enums in your class, the only
	 *    object for the Enum is the instance constant that's declared
	 *    inside the Enum.
	 * 3. Handles (de)serialization correctly, compared to a regular
	 *    class, where a singleton once serialized, and then deserialized,
	 *    the object might not be the same, making two singleton objects,
	 *    which is something we want to avoid.
	 */
}

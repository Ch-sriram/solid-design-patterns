package com.ram.java.designpatterns.abstractfactory.example1;

/**
 * Represents an Abstract Compute Instance Object
 *
 * @apiNote Abstract Product
 */
public interface Instance {
	/**
	 * Represents the compute instance's compute capacity.
	 */
	enum Capacity {
		MICRO,
		SMALL,
		LARGE
	};

	/**
	 * Defines the behaviour for starting the compute instance.
	 */
	void start();

	/**
	 * Defines the behaviour to stop the compute instance.
	 */
	void stop();

	/**
	 * For defining the behaviour of how a {@link Storage} instance
	 * is attached to this specific compute instance.
	 *
	 * @param storage
	 */
	void attachStorage(Storage storage);
}

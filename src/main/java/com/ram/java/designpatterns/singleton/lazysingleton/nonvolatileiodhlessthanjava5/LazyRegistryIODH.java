package com.ram.java.designpatterns.singleton.lazysingleton.nonvolatileiodhlessthanjava5;

import com.ram.java.designpatterns.singleton.eagersingleton.EagerRegistry;

/**
 * Singleton pattern using Lazy Initialization Holder Class.
 * This ensures that we've a lazy initialization without worrying
 * about synchronization. 
 */
@SuppressWarnings("unused")
public class LazyRegistryIODH {

	// Disallow creation of any instance of this class.
	private LazyRegistryIODH() {
		System.out.println("Created LazyRegistryIODH instance.");
	}

	// Instead of declaring a static INSTANCE variable for this class,
	// in this solution, a static inner class called RegistryHolder is
	// created as follows:
	private static class RegistryHolder {
		// This INSTANCE is only created (lazily), whenever the
		// {@code getInstance()} is called.
		static LazyRegistryIODH INSTANCE = new LazyRegistryIODH();
	}

	/**
	 * The JVM guarantees that a class is initialized exactly once,
	 * and that initialization is thread-safe.
	 *
	 *     T1                              T2
     * 
     * getInstance()                   getInstance()
     *      │                               │
     *      ▼                               ▼
     * SingletonHolder.INSTANCE       SingletonHolder.INSTANCE
     *      │                               │
     *      └──────────────┬────────────────┘
     *                     ▼
     *              JVM initializes
     *              SingletonHolder
     *                     │
     *                     ▼
     *         INSTANCE = new Singleton()
     *                     │
     *                     ▼
     *          initialization complete
     *                     │
     *              ┌──────┴──────┐
     *              ▼             ▼
     *             T1            T2
     *              │             │
     *              └──────┬──────┘
     *                     ▼
     *              same INSTANCE
	 */
	public static LazyRegistryIODH getInstance() {
		return RegistryHolder.INSTANCE;
	}

	/**
	 * In Eager Singleton (viz. {@link EagerRegistry}, the instance is created
	 * whenever the class itself is being loaded, and therefore, the singleton
	 * variable always exists in memory, created by the respective IoC container.
	 *
	 * But in this particular implementation, the current class {@link LazyRegistryIODH}
	 * is loaded, but the {@code INSTANCE} is not created during loading of class,
	 * the actually {@code INSTANCE} is only created when {@code getInstance()} method
	 * is called by any client-caller.
	 *
	 * This can be seen in action inside the {@link Client}.
	 */
}

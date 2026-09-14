package com.ram.java.designpatterns.singleton.lazysingleton.doublecheckednullandlocking;

/**
 * Demonstrates the usage of {@link LazyRegistryWithDoubleNullCheckLocking}
 * object, which is also a demonstration of Lazy Singleton Pattern.
 */
public class Client {

	public static void main(String[] args) {
		// Creation of the object by any Client isn't possible, as can be seen below:
		// LazyRegistryWithDoubleNullCheckLocking registry = new LazyRegistryWithDoubleNullCheckLocking();

		LazyRegistryWithDoubleNullCheckLocking registry = LazyRegistryWithDoubleNullCheckLocking.getInstance();
		LazyRegistryWithDoubleNullCheckLocking registry2 = LazyRegistryWithDoubleNullCheckLocking.getInstance();

		// Both registry and registry2 objects are referencing the same object in memory.
		System.out.print(registry == registry2);	// O/P: true
	}

}

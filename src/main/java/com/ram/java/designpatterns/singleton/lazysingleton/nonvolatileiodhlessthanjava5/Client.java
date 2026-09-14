package com.ram.java.designpatterns.singleton.lazysingleton.nonvolatileiodhlessthanjava5;

/**
 * Driver program that demonstrates Lazy Singleton using
 * Initialization Holder Class.
 */
public class Client {

	public static void main(String[] args) {
		/**
		 * The reference to {@link LazyRegistryIODH} ensures that Java
		 * loads the class for LazyRegistryIODH in memory.
		 *
		 * NOTE: This does NOT create the INSTANCE of LazyRegistryIODH class.
		 * Only the class is loaded, even though the inner static class
		 * exists in LazyRegistryIODH class, the inner static class
		 * isn't loaded until getInstance() is actually called.
		 */
		LazyRegistryIODH singleton;
		System.out.println("Done loading class LazyRegistryIODH");

		// Here, during the call to getInstance(), the actual singleton instance
		// for LazyRegistryIODH is created.
		singleton = LazyRegistryIODH.getInstance();		// O/P: Created LazyRegistryIODH instance.

		// Also, LazyRegistryIODH$RegistryHolder's reference/instance cannot
		// be created from outside since the inner static class itself has
		// private visibility.
	}

}

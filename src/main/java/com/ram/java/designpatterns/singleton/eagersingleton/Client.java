package com.ram.java.designpatterns.singleton.eagersingleton;

/**
 * Driver program demonstrating Eager Singleton Initialization.
 */
public class Client {

	public static void main(String[] args) {

		// The following cannot be done, because the constructor itself is private
		// EagerRegistry eagerRegistry = new EagerRegistry(); // not allowed

		// But we can get a single instance of the EagerRegistry object as follows.
		EagerRegistry eagerRegistry = EagerRegistry.getInstance();
		EagerRegistry eagerRegistry2 = EagerRegistry.getInstance(); // no matter how many times we call, the same object is being returned here

		System.out.println(eagerRegistry == eagerRegistry2); // true: since both references store the same object reference.
	}

}

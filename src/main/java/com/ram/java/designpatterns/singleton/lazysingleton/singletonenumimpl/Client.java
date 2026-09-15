package com.ram.java.designpatterns.singleton.lazysingleton.singletonenumimpl;

/**
 * Driver program that demonstrates the usage of Singleton pattern using enums. 
 */
public class Client {

	public static void main(String[] args) {
		RegistryEnum instance = RegistryEnum.INSTANCE;
		RegistryEnum instance2 = RegistryEnum.getInstance();

		System.out.println(instance == instance2);	// O/P: true
	}

}

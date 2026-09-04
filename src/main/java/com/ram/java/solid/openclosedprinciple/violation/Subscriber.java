package com.ram.java.solid.openclosedprinciple.violation;

public class Subscriber {
	
	/**
	 * Both {@link ISPSubscriber} and {@link PhoneSubscriber} classes
	 * are violating Open Closed Principle.
	 * 
	 * Both classes have common fields: subscriberId, address, phoneNumber,
	 * and baseRate, which can easily be extracted to a base class.
	 * 
	 * The base class should be open for extension, which means it shouldn't
	 * be a final class.
	 * 
	 * The base class should be closed for modification, which means it should
	 * be made an abstract class, having methods that are to be implemented
	 * by the child (derived) classes, as abstract, such methods could be overriden.
	 */

}

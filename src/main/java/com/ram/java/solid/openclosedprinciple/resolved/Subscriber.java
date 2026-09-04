/**
 * 
 */
package com.ram.java.solid.openclosedprinciple.resolved;

/**
 * Subscriber is the base class, which is Open for extension, but Closed for modification.
 */
public abstract class Subscriber {

	private long subscriberId;
	
	private long phoneNumber;
	
	private int baseRate;

	private String address;
	
	// This can be overridden by any child (derived) class,
	// and that now allows the Open for extension clause.
	// Also, since this is an abstract class, any object
	// of this class cannot be created, and hence, any further
	// code changes to this class is usually not done,
	// therefore, it also adheres to Closed for modification clause
	// of the Open Closed Principle.
	public abstract double calculateBill();

	/**
	 * @return the subscriberId
	 */
	public long getSubscriberId() {
		return subscriberId;
	}

	/**
	 * @param subscriberId the subscriberId to set
	 */
	public void setSubscriberId(long subscriberId) {
		this.subscriberId = subscriberId;
	}

	/**
	 * @return the phoneNumber
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the baseRate
	 */
	public int getBaseRate() {
		return baseRate;
	}

	/**
	 * @param baseRate the baseRate to set
	 */
	public void setBaseRate(int baseRate) {
		this.baseRate = baseRate;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}

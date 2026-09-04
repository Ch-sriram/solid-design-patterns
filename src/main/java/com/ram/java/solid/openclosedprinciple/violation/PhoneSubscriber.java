package com.ram.java.solid.openclosedprinciple.violation;

/**
 * Model that represents a mobile network subscriber.
 * Example: Vodafone Idea, BSNL, Airtel, and Jio subscribers.
 */
public class PhoneSubscriber {

	private long subscriberId;
	
	private String address;
	
	private long phoneNumber;
	
	private int baseRate;
	
	public double calculateBill() {
		return 0d;
	}

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
	
	
}

package com.ram.java.solid.openclosedprinciple.violation;

/**
 * Class that represents and Internet Service Provider Subscriber.
 * Example: JioFiber, Airtel Fiber user.
 */
public class ISPSubscriber {

	private long subscriberId;
	
	private String address;
	
	private long phoneNumber;
	
	private int baseRate;
	
	private long freeUsage;
	
	public ISPSubscriber() {
	}
	
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

	/**
	 * @return the freeUsage
	 */
	public long getFreeUsage() {
		return freeUsage;
	}

	/**
	 * @param freeUsage the freeUsage to set
	 */
	public void setFreeUsage(long freeUsage) {
		this.freeUsage = freeUsage;
	}
	
}

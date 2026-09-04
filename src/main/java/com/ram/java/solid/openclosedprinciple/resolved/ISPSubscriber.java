/**
 * 
 */
package com.ram.java.solid.openclosedprinciple.resolved;

import java.util.List;

import com.ram.java.solid.openclosedprinciple.InternetSessionHistory;

/**
 * {@link Subscriber} class is Open for Extension, but Closed for Modification.
 * The {@link ISPSubscriber} class is overriding {@link Subscriber#calculateBill()}
 * method here, which enforces the Open for Extension of OCP.
 */
public class ISPSubscriber extends Subscriber {
	
	/**
	 * ISPs usually give some Internet data usage,
	 * which is free of cost, which can be noted
	 * down in freeUsage variable
	 */
	private long freeUsage;
	
	@Override
	public double calculateBill() {
		List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(getSubscriberId());
		long totalDataUsed = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
		long totalDataForBilling = totalDataUsed - getFreeUsage();

		return totalDataForBilling <= 0d ? 0d : ((totalDataUsed * getBaseRate()) / 100d);
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

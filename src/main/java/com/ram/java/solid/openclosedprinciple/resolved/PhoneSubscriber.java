/**
 * 
 */
package com.ram.java.solid.openclosedprinciple.resolved;

import java.util.List;

import com.ram.java.solid.openclosedprinciple.CallHistory;

/**
 * Open for Extension - {@link Subscriber} base class, and
 * {@link PhoneSubscriber} derived class.
 * 
 * Overriding {@link Subscriber#calculateBill()}
 */
public class PhoneSubscriber extends Subscriber {
	@Override
	public double calculateBill() {				// As can be seen, the Subscriber class is Open for Extension here.
		List<CallHistory.Call> calls = CallHistory.getCurrentCalls(getSubscriberId());
		long totalDuration = calls.stream().mapToLong(CallHistory.Call::getDuration).sum();
		return (totalDuration * getBaseRate()) / 100;
	}
}

package com.ram.java.designpatterns.abstractfactory.example1;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Represents an AWS EC2 Instance. 
 *
 * @apiNote Concrete Product for Abstract Product related to {@link Instance}
 */
public class Ec2Instance implements Instance {
	private static final AtomicLong NEXT_ID = new AtomicLong();

	private long instanceId = NEXT_ID.incrementAndGet();
	private Capacity capacity;

	public Ec2Instance(Capacity capacity) {
		this.instanceId = NEXT_ID.incrementAndGet();
		this.capacity = capacity;
		System.out.println("Created AWS EC2 Instance: " + this);
	}

	@Override
	public void start() {
		System.out.println("Started AWS EC2 Instance (" + instanceId + ").");
	}

	@Override
	public void stop() {
		System.out.println("Stopped AWS EC2 Instance (" + instanceId + ").");
	}

	@Override
	public void attachStorage(Storage storage) {
		System.out.println("Attached " + storage + " to EC2 instance: " + instanceId);
	}

	@Override
	public String toString() {
		return "Ec2Instance [instanceId=" + instanceId + ", capacity=" + capacity + "]";
	}

	/**
	 * @return the capacity
	 */
	public Capacity getCapacity() {
		return capacity;
	}
}

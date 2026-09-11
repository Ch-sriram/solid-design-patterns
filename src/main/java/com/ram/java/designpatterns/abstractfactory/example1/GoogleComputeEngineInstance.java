package com.ram.java.designpatterns.abstractfactory.example1;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Represents an Google Compute Engine (GCE) Instance.
 *
 * @apiNote Concrete Product from Abstract Product of type {@link Instance}
 */
public class GoogleComputeEngineInstance implements Instance {
	private static final AtomicLong NEXT_ID = new AtomicLong();

	private long instanceId = NEXT_ID.incrementAndGet();
	private Capacity capacity;

	public GoogleComputeEngineInstance(Capacity capacity) {
		this.instanceId = NEXT_ID.incrementAndGet();
		this.capacity = capacity;
		System.out.println("Created Google Compute Engine (GCE) Instance: " + this);
	}

	@Override
	public void start() {
		System.out.println("Started GCE Instance (" + instanceId + ")");
	}

	@Override
	public void stop() {
		System.out.println("Stopped GCE Instance (" + instanceId + ")");
	}

	@Override
	public void attachStorage(Storage storage) {
		System.out.println("Attached: " + storage + " to compute engine instance: " + instanceId);
	}

	@Override
	public String toString() {
		return "GoogleComputeEngineInstance [instanceId=" + instanceId + ", capacity=" + capacity + "]";
	}

	/**
	 * @return the capacity
	 */
	public Capacity getCapacity() {
		return capacity;
	}
}

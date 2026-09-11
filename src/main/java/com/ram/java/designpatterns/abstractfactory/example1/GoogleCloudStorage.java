package com.ram.java.designpatterns.abstractfactory.example1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a Google Cloud Storage Resource for attaching to {@link GoogleComputeEngineInstance}.
 *
 * @apiNote Concrete Product for Abstract Product related to {@link Storage}
 */
public class GoogleCloudStorage implements Storage {

	private static final AtomicInteger NEXT_ID = new AtomicInteger();

	private int id;
	private int capacityInMib;

    public GoogleCloudStorage(int capacityInMib) {
    	this.id = NEXT_ID.incrementAndGet();
		this.setCapacityInMib(capacityInMib);
		System.out.println("Allocated " + capacityInMib + " on Google Cloud Storage (" + id + ")");
	}

	@Override
	public String getId() {
		return Integer.toString(id);
	}

	/**
	 * @return the capacityInMib
	 */
	public int getCapacityInMib() {
		return capacityInMib;
	}

	/**
	 * @param capacityInMib the capacityInMib to set
	 */
	private void setCapacityInMib(int capacityInMib) {
		this.capacityInMib = capacityInMib;
	}

	@Override
	public String toString() {
		return "GoogleCloudStorage [id=" + id + ", capacityInMib=" + capacityInMib + "]";
	}
}

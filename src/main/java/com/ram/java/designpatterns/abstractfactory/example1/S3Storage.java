package com.ram.java.designpatterns.abstractfactory.example1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents AWS S3 Storage Resource.
 *
 * @apiNote Concrete Product of Abstract Product from {@link Storage}
 */
public class S3Storage implements Storage {
	
	private static final AtomicInteger NEXT_ID = new AtomicInteger();
	
	private int id;
	private int capacityInMiB;

	public S3Storage(int capacityInMiB) {
		this.id = NEXT_ID.incrementAndGet();
		this.setCapacityInMiB(capacityInMiB);
		System.out.println("Allocated " + capacityInMiB + " on S3 (" + id + ")");
	}

	@Override
	public String getId() {
		return Integer.toString(id);
	}

	/**
	 * @return the capacityInMiB
	 */
	public int getCapacityInMiB() {
		return capacityInMiB;
	}

	/**
	 * @param capacityInMiB the capacityInMiB to set
	 */
	private void setCapacityInMiB(int capacityInMiB) {
		this.capacityInMiB = capacityInMiB;
	}

	@Override
	public String toString() {
		return "S3Storage [id=" + id + ", capacityInMiB=" + capacityInMiB + "]";
	}
}

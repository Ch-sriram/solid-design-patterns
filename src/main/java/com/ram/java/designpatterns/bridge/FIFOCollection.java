package com.ram.java.designpatterns.bridge;

/**
 * Abstraction for First In First Out Collections.
 */
public interface FIFOCollection<T> {

	/**
	 * Offer/insert an element into the collection.
	 *
	 * @param element
	 */
	public void offer(T element);

	/**
	 * Poll/remove the first-in element from the collection.
	 *
	 * @return
	 */
	public T poll();
}

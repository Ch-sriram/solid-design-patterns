package com.ram.java.designpatterns.bridge;

/**
 * Refined Abstraction for First In First Out Collections, a Queue.
 */
public class Queue<T> implements FIFOCollection<T> {

	/**
	 * This Queue is composed of this LinkedList.
	 * Using this LinkedList, we're providing the functionality
	 * of a queue. The implementation details of the LinkedList
	 * can be decided by the client, during runtime.
	 */
	private LinkedList<T> list;

	public Queue(LinkedList<T> list) {
		this.list = list;
	}

	@Override
	public void offer(T element) {
		list.addLast(element);
	}

	@Override
	public T poll() {
		return list.removeFirst();
	}

	@Override
	public String toString() {
		return list.toString();
	}
}

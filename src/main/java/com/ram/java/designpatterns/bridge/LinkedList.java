package com.ram.java.designpatterns.bridge;

/**
 * Implementor interface for Abstraction - LinkedList.  
 */
public interface LinkedList<T> {

	public void addFirst(T element);

	public T removeFirst();

	public void addLast(T element);

	public T removeLast();

	public int getSize();
}

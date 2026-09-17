package com.ram.java.designpatterns.bridge;

/**
 * Concrete Implementation for Abstract Implementor {@link LinkedList}.
 */
public class ArrayLinkedList<T> implements LinkedList<T> {

	private Object[] list;

	private int capacity;
	private int size;

	public ArrayLinkedList() {
		this(0);
	}

	public ArrayLinkedList(int capacity) {
		list = new Object[capacity];
		size = 0;
	}
	
	private void resize() {
		capacity = (capacity + 1) * 2;
		Object[] newList = new Object[capacity];
		System.arraycopy(list, 0, newList, 0, size);
		list = newList;
	}

	@Override
	public void addFirst(T element) {
		if (list.length == capacity) {
			resize();
		}

		if (size == 0) {
			list[0] = element;
		} else {
			// Move all elements rightwards by one position.
			for (int i = size - 1; i > 0; --i) {
				list[i+1] = list[i];
			}

			list[0] = element;
		}

		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T removeFirst() {
		if (size == 0) {
			return null;
		}

		T firstElement = (T) list[0];

		// Move all elements, leftwards by 1 position.
		// System.arraycopy(list, 0, list, 1, size); // the below for loop is the same as this.
		for (int i = 1; i < size; ++i) {
			list[i-1] = list[i];
		}

		list[size-1] = 0;
		size--;

		return firstElement;
	}

	@Override
	public void addLast(T element) {
		if (list.length == capacity) {
			resize();
		}

		if (size == 0) {
			list[0] = element;
		} else {
			list[size] = element;
		}

		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T removeLast() {
		// Remove the last element.
		// System.arraycopy(list, 1, list, 0, size); // the below statement is the same as this.
		return (T) list[--size];
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");

		for (int i = 0; i < size; ++i) {
			sb.append(list[i]);
			sb.append(" -> ");
		}
		sb.append("null]");

		return sb.toString();
	}

}

package com.ram.java.designpatterns.bridge;

/**
 * Concrete Implementation for Abstract Implementor Interface {@link LinkedList}.
 */
public class SinglyLinkedList<T> implements LinkedList<T> {

	private Node<T> head = null;
	private Node<T> tail = null;
	private int size;

	public SinglyLinkedList() {}

	public SinglyLinkedList(Node<T> node) {
		this.head = this.tail = node;
	}

	@Override
	public void addFirst(T element) {
		if (head == null) {
			this.head = this.tail = new Node<T>(element);
		} else {
			Node<T> newNode = new Node<T>(element);
			newNode.next = head;
			head = newNode;
		}

		size++;
	}

	@Override
	public T removeFirst() {
		if (head == null) {
			return null;
		}

		Node<T> oldHead = head;
		head = head.next;

		if (head == null) {
			tail = null;
		}

		size--;

		return oldHead.data;
	}

	@Override
	public void addLast(T element) {
		if (head == null) {
			this.head = this.tail = new Node<T>(element);
		} else {
			Node<T> newNode = new Node<T>(element);
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	@Override
	public T removeLast() {
		if (tail == null) {
			return null;
		}

		Node<T> curr = head;
		Node<T> prev = null;
		while (curr != tail && curr != null) {
			prev = curr;
			curr = curr.next;
		}

		Node<T> oldTail = tail;
		tail = prev;

		if (tail == null) {
			head = null;
		} else {
			tail.next = null;
		}
		
		size--;

		return oldTail.data;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		Node<T> curr = head;

		while (curr != null) {
			sb.append(curr.data);
			sb.append(" -> ");
			curr = curr.next;
		}
		sb.append("null ]");

		return sb.toString();
	}
}

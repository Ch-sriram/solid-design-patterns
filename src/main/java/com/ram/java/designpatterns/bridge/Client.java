package com.ram.java.designpatterns.bridge;

/**
 * Driver program that demonstrates bridge pattern using Queue as a LinkedList instance.
 * The implementation of LinkedList can differ, as follows:
 * 1. SinglyLinkedList
 * 2. ArrayLinkedList 
 */
public class Client {

	public static void main(String[] args) {
		FIFOCollection<Integer> collection = new Queue<>(new SinglyLinkedList<>());
		collection.offer(10);
		collection.offer(20);
		collection.offer(-100);
		System.out.println(collection);
		System.out.println(collection.poll());
		System.out.println(collection);
		System.out.println(collection.poll());
		System.out.println(collection);
		System.out.println(collection.poll());
		System.out.println(collection);
		System.out.println(collection.poll());
		System.out.println(collection);

		System.out.println("\n*********************************************************************************\n");

		FIFOCollection<String> collection2 = new Queue<>(new ArrayLinkedList<>());
		collection2.offer("Ram");
		collection2.offer("is");
		collection2.offer("Programming");
		System.out.println(collection2);
		System.out.println(collection2.poll());
		System.out.println(collection2);
		System.out.println(collection2.poll());
		System.out.println(collection2);
		System.out.println(collection2.poll());
		System.out.println(collection2);
		System.out.println(collection2.poll());
		System.out.println(collection2);
		System.out.println(collection2.poll());
		System.out.println(collection2);
	}

	/**
	 * Output:
	 * ------
	 *
	 * [ 10 -> 20 -> -100 -> null ]
     * 10
     * [ 20 -> -100 -> null ]
     * 20
     * [ -100 -> null ]
     * -100
     * [ null ]
     * null
     * [ null ]
     * 
     * *********************************************************************************
     * 
     * [ Ram -> is -> Programming -> null]
     * Ram
     * [ is -> Programming -> null]
     * is
     * [ Programming -> null]
     * Programming
     * [ null]
     * null
     * [ null]
     * null
     * [ null]
	 */

}

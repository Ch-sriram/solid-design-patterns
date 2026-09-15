package com.ram.java.designpatterns.objectpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

/**
 * The actual object pool that manages {@link Image} object. 
 */
public class ObjectPool<T extends Poolable> {

	// Thread-safe queue in Java
	private BlockingQueue<T> availablePool;

	public ObjectPool(Supplier<T> creator, int count) {
		this.availablePool = new LinkedBlockingQueue<>();
		for (int i = 0; i < count; i++) {
			availablePool.offer(creator.get());
		}
	}
	
	public T get() {
		try {
			// In a real world implementation, if the availablePool is empty, we may want to decide what we want to do.
			// 1. We may want to create a new object if the pool is empty, add that object in the pool and return, OR
			// 2. If it's a resource which is limited (like a database request pool, or N/W requests, etc),
			//    we may want to wait before the resource is available again. 
			return availablePool.take();
		} catch (InterruptedException ex) {
			System.err.println("take() was interrupted: " + ex);
		}

		// In the real world, 
		return null;
	}

	public void release(T obj) {
		obj.reset();
		try {
			availablePool.put(obj);
		} catch (InterruptedException e) {
			System.err.println("put() was interrupted: " + e);
		}
	}
}

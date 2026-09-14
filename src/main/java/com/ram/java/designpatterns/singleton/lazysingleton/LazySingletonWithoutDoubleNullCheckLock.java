package com.ram.java.designpatterns.singleton.lazysingleton;

/**
 * This class doesn't make use of double null checking, but it does locking when getting an instance of this class.
 *
 * When double {@code null} checking isn't done, then there's a chance of race condition.
 */
public class LazySingletonWithoutDoubleNullCheckLock {

	// Disallows any instance creation for this class
	private LazySingletonWithoutDoubleNullCheckLock() {}

	private static LazySingletonWithoutDoubleNullCheckLock INSTANCE;

	public static LazySingletonWithoutDoubleNullCheckLock getInstance() {
		// 1. We make a null check, whether the INSTANCE already exists or not.
		if (INSTANCE == null) {	// INSTANCE is null

			// 2. Once any thread reaches this part here, the creation should only
			//	  be handled by a single thread, one at a time.
			//
			//    Therefore, making this a Critical Section (synchronized block),
			//    should be ideal.

			/**
			 * POINT-A: (1. T2 busy-waiting) -> (2. T2 enters critical section)
			 */
			synchronized (LazySingletonWithoutDoubleNullCheckLock.class) {
				/**
				 * POINT-B (1. T1 executing) -> (2. T2 executing)
				 */
				INSTANCE = new LazySingletonWithoutDoubleNullCheckLock();
				// Interestingly enough, there's a chance that when T1 is creating
				// this class' instance inside POINT-B, after T1 completes its execution,
				// the Critical Section is now free to be entered by any other thread.
				//
				// At the same time, T2, which is busy-waiting at POINT-A, can enter
				// POINT-B (Critical Section), and start executing the code inside.
				//
				// Both T1 & T2 create the same INSTANCE twice, and the last created
				// INSTANCE, by any thread, will be assigned to INSTANCE reference.
				//
				// This happens because inside POINT-B (critical section), there's
				// no checking of whether the INSTANCE is null, or not.
				//
				// Therefore, in a standard way, Double Null Check of INSTANCE is done
				// with Locking (making the block synchronized).
				//
				// That particular implementation can be found at:
				// LazyRegistryWithDoubleNullCheckLocking.java
			}
		}

		// INSTANCE is NOT null
		return INSTANCE;
	}
}

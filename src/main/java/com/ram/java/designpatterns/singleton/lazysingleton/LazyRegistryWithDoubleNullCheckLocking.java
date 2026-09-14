package com.ram.java.designpatterns.singleton.lazysingleton;

/**
 * This class demonstrates singleton pattern using Double Checked Locking (DCL) or "Classic" Singleton.
 * This is also a Lazy Initializing Singleton.
 *
 * This implementation relies on the Java Memory Model's guarantees for {@code volatile} introduced
 * with the Java 5's memory model. Therefore, correct double-checked locking using volatile requires
 * Java 5 or later.
 */
public class LazyRegistryWithDoubleNullCheckLocking {

	// Disallows creation of this instance outside this class.
	private LazyRegistryWithDoubleNullCheckLocking() {
	}

	/**
	 * To ensure that thread T2 doesn't read a stale value of INSTANCE, we make use of {@code volatile} keyword.
	 *
	 * How does {@code volatile} help here?
	 * - During the first read of {@code INSTANCE} by T2 at POINT-X, the {@code INSTANCE} may or may not be {@code null}.
	 * - During that time, since both T1 & T2 do NOT share the same Critical Section (or Monitor), the changes made by T1
	 *   aren't known to T2, and therefore, what can happen is that T2 can read a stale value of {@code INSTANCE}.
	 * - The {@code INSTANCE}'s value can be stale because by the time T2 reads, there's a good chance that T1 is in the
	 *   process of creating the instance of {@code LazyRegistryWithDoubleNullCheckLocking} and assigning it to
	 *   {@code INSTANCE}.
	 *   - During such a time, if T2 tries to read {@code INSTANCE}, the changes are that the actual value of
	 *     {@code INSTANCE} might not reflect in the memory correctly, because T1 has currently acquired the lock for the
	 *     monitor (only one thread can acquire the lock of a monitor/critical-section).
	 *   - When T1 releases the lock, Java's Memory Model (JMM) establishes the appropriate happens-before relationship
	 *     with a subsequent acquisition by T2.
	 *   - A mental model like the following should be good to visualize what's happening:
	 *     T1
     *     │
     *     │ INSTANCE = new Singleton()
     *     │
     *     │ volatile write
     *     │
     *     └────────────────── happens-before ──────────────►
     *                                                        T2
     *                                                        │
     *                                                        │ volatile read
     *                                                        ▼
     *                                                 sees the published
     *                                                 value and its state
     *
	 * - Therefore, to provide memory visibility to all the threads, making use of {@code volatile} is necessary.
	 *   - {@code volatile} keyword guarantees a "happens-before" relationship, meaning, all threads can see
	 *     what has already happened to the reference which is {@code volatile}, at runtime.
	 *   - And also, so that T2 doesn't read a stale value, {@code volatile} assures safe publication of the
	 *     object's initialization.
	 */
	private static volatile LazyRegistryWithDoubleNullCheckLocking INSTANCE;

	/**s
	 * This specific implementation of Lazy Initialization of Singleton
	 * using Double Null Check Locking, doesn't get into any Race Conditions.
	 *
	 * @return only instance of {@link LazyRegistryWithDoubleNullCheckLocking}
	 */
	public static LazyRegistryWithDoubleNullCheckLocking getInstance() {
		// 1. Check if INSTANCE is null or not.
		/**
		 * POINT-X: (1. T2 reads INSTANCE) -> (2. T1 at POINT-A/B/C/D - can be anywhere)
		 */
		if (INSTANCE == null) {
            // 2. Only one thread allowed to create the instance, for the first time,
			//    rest all threads can make use of the instance that was already created
			//    by one of the previous threads.

			/**
			 * POINT-A: (1. T2 is busy-waiting) -> (2. T2 enters critical section)
			 */
			synchronized (LazyRegistryWithDoubleNullCheckLocking.class) {        // You cannot use `this`, since the method is static.

				/**
				 * POINT-B: (1. T1 is executing) -> (2. T2 checks if INSTANCE is null or not)
				 */
				if (INSTANCE == null) {

					/**
					 * POINT-C: (1. T1 creates the object of this class) -> (2. T2 cannot enter this if-block, and hence cannot create an instance of this class. 
					 */
					INSTANCE = new LazyRegistryWithDoubleNullCheckLocking();
				}
			}
		}

		/**
		 * POINT-D: (1. T1 returns the created INSTANCE) -> (2. T2 could NOT enter if-block, and as per the execution flow, returns the existing INSTANCE.
		 */
		return INSTANCE;
	}
}

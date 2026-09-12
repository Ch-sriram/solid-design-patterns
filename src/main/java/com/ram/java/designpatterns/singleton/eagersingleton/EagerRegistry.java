package com.ram.java.designpatterns.singleton.eagersingleton;

/**
 * 
 * @apiNote class makes use of Eager Initialization of Singleton instance.
 */
public class EagerRegistry {

	/**
	 * A private constructor disallows any inheritance of this class!
	 */
	private EagerRegistry() {}

	private static final EagerRegistry INSTANCE = new EagerRegistry();

	/**
	 * The APIs making use of {@link EagerRegistry}, can only access the instance
	 * via this method.
	 *
	 * @return
	 */
	public static EagerRegistry getInstance() {
		return INSTANCE;
	}
}

package com.ram.java.designpatterns.prototype;

import javafx.geometry.Point3D;

/**
 * Driver program to demonstrate Prototype pattern.
 */
public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		Swordsman swordsman = new Swordsman();
		swordsman.move(new Point3D(-10f, 0f, 0f), 20);
		swordsman.attack();
		System.out.println(swordsman);

		Swordsman swordsman2 = (Swordsman) swordsman.clone();
		System.out.println("Cloned Swordsman: " + swordsman2);

		General general = new General();
		System.out.println(general);

		// This will throw a CloneNotSupportedException
//		General generalClone = (General) general.clone();

		// Resetting the state isn't allowed, as this throws an UnsupportedOperationException
//		general.reset();
	}
	
	/**
	 * Output:
	 * ------
	 *
	 * SCENARIO-A: When general.clone() is invoked at L23
	 *
	 * Swordsman [state=attacking @ Point3D [x = -20.0, y = 0.0, z = 0.0]]
     * Cloned Swordsman: Swordsman [state=idle @ Point3D [x = 0.0, y = 0.0, z = 0.0]]
     * General [state=idle @ Point3D [x = 0.0, y = 0.0, z = 0.0]]
     * Exception in thread "main" java.lang.CloneNotSupportedException: Generals are unique
     * 	at com.ram.java.designpatterns.prototype.General.clone(General.java:18)
     * 	at com.ram.java.designpatterns.prototype.Client.main(Client.java:23)
     * 
     * --------------------------------------------------------------------------------------
     * 
     * SCENARIO-2: When general.reset() is invoked at L26
     * 
     * Swordsman [state=attacking @ Point3D [x = -20.0, y = 0.0, z = 0.0]]
     * Cloned Swordsman: Swordsman [state=idle @ Point3D [x = 0.0, y = 0.0, z = 0.0]]
     * General [state=idle @ Point3D [x = 0.0, y = 0.0, z = 0.0]]
     * Exception in thread "main" java.lang.UnsupportedOperationException: Reset not supported
     * 	at com.ram.java.designpatterns.prototype.General.reset(General.java:23)
     * 	at com.ram.java.designpatterns.prototype.Client.main(Client.java:27)
     * 
	 */

}


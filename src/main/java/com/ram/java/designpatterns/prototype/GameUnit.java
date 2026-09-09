package com.ram.java.designpatterns.prototype;

import javafx.geometry.Point3D;

/**
 * This class represents an abstract prototype,
 * and defines the {@code clone} method. 
 */
public abstract class GameUnit implements Cloneable {

	private Point3D position;

	public GameUnit() {
		position = Point3D.ZERO;
	}

	public GameUnit(float x, float y, float z) {
		position = new Point3D(x, y, z);
	}

	public void move(Point3D direction, float distance) {
		Point3D finalMove = direction.normalize();
		finalMove = finalMove.multiply(distance);
		position = position.add(finalMove);
	}

	public Point3D getPosition() {
		return position;
	}

	@Override
	public GameUnit clone() throws CloneNotSupportedException {
		// Decide whether we need a shallow/deep copy.
		// In our case, Point3D stores only variables, and not any Collection.
		// Therefore, having a shallow copy is enough here.
		GameUnit unitClone = (GameUnit) super.clone(); // Create a shallow copy
		unitClone.initialize();
		return unitClone;
	}

	/**
	 * Whenever a clone is created, it's always a good idea to reset the state
	 * of the fields inside the cloned instance.
	 */
	protected void initialize() {
		this.position = Point3D.ZERO;
		reset();
	}

	/**
	 * Enforce the overriding of initialization using the {@code reset()} method.
	 * This {@code reset()} method is acting as {@code initialize()} method for
	 * the subclasses.
	 */
	protected abstract void reset();

}

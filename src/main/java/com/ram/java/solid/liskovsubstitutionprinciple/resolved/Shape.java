package com.ram.java.solid.liskovsubstitutionprinciple.resolved;

/**
 * Defines the behaviour any shape like Circle, Square, Rectangle, Rhombus, etc.
 */
public interface Shape {

	/**
	 * Computes the area of any shape.
	 * @return calculated area as an integer
	 */
	public int computeArea();
}

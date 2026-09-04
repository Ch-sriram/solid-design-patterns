package com.ram.java.solid.liskovsubstitutionprinciple.resolved;

/**
 * The only way for Square class to NOT violate the Liskov Substitution Principle, is to ensure that we get rid of the Square IS-A Rectangle relationship,
 * and treat Square as a Square, and Rectangle as a rectangle.
 * 
 * The idea is that there will be a Shape interface, which will enforce the implementation of the behaviour for both Square, and Rectangle classes.
 */
public class Square implements Shape {
	
	private int side;

	public Square(int side) {
		this.side = side;
	}

	@Override
	public int computeArea() {
		return side * side;
	}

	/**
	 * @return the side
	 */
	public int getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(int side) {
		this.side = side;
	}

}

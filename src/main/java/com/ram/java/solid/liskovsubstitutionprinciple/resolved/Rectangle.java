package com.ram.java.solid.liskovsubstitutionprinciple.resolved;

/**
 * Rectangle will now be treated as a Rectangle, and not be a Base class for Square.
 * This should now ensure that Rectangle itself is treated as a Shape, and not as a Base
 * class for Square class.
 */
public class Rectangle implements Shape {

	private int height;

	private int width;

	public Rectangle(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}

	@Override
	public int computeArea() {
		return height * width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
}

package com.ram.java.solid.liskovsubstitutionprinciple.violation;

/**
 * Rectangle is a 3D shape that consists
 * of height and weight, and contains an
 * Area.
 */
public class Rectangle {
	
	private int height;

	private int width;

	public Rectangle(int height, int width) {
		this.setHeight(height);
		this.setWidth(width);
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
	 * @return the weight
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the weight to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Computes the area of a rectangle
	 * @return
	 */
	public int computeArea() {
		return height * width;
	}
}

package com.ram.java.solid.liskovsubstitutionprinciple.violation;

/**
 * Since Square IS-A Rectangle, both setWidth & setHeight
 * are supposed to be implemented at the level of Square class,
 * where setting of height should automatically lead to setting
 * of width as well, since in a square, both height and width are same,
 * and is termed as side.
 * 
 * In the same way, setting of width should automatically set height
 * to the same width, since width = height = side in a Square.
 */
public class Square extends Rectangle {

	public Square(int side) {
		super(side, side);
	}
	
	@Override
	public void setWidth(int width) {
		setSide(width);
	}
	
	@Override
	public void setHeight(int height) {
		setSide(height);
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(int side) {
		super.setHeight(side);
		super.setWidth(side);
	}
}

package com.ram.java.solid.liskovsubstitutionprinciple.violation;

/**
 * Driver class for the demo of LSP, and how it's violated. 
 */
public class Main {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(10, 20);
		System.out.println(rectangle.computeArea());
		
		Square square = new Square(10);
		System.out.println(square.computeArea());
		
		useRectangle(rectangle);
		useRectangle(square);		// this is possible because, Square IS-A Rectangle, [OR] Rectangle <- Square, [OR] Square extends Rectangle 

	}

	private static void useRectangle(Rectangle rectangle) {
		rectangle.setHeight(20);
		rectangle.setWidth(30);
		assert rectangle.getHeight() == 20 : "Height is NOT equal to 20";	// this assertion will fail for Square instance, since the behaviour has altered for the Square class' setHeight and setWidth, and for a Square, width = height = side.
		assert rectangle.getWidth() == 30 : "Width is NOT equal to 30";
	}
}

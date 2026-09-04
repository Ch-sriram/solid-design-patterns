package com.ram.java.solid.liskovsubstitutionprinciple.resolved;

/**
 * Driver program to show LSP in action.
 * The previous example had LSP violated
 * due to Square behaving has a Rectangle,
 * and setting either height or width with
 * different values breaking the assertion.
 */
public class Main {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(10, 20);
		System.out.println(rectangle.computeArea());
		
		Square square = new Square(10);
		System.out.println(square.computeArea());

		useRectangle(rectangle);
//		useRectangle(square);		// Both Rectangle & Square are now Shape(s), and therefore Rectangle ≠ Square.
		
		// Square now needs a separate useSquare method to be used correctly.
	}

	private static void useRectangle(Rectangle rectangle) {
		rectangle.setHeight(20);
		rectangle.setWidth(30);
		assert rectangle.getHeight() == 20 : "Height ≠ 20";
		assert rectangle.getWidth() == 30 : "Width ≠ 30";
	}

}

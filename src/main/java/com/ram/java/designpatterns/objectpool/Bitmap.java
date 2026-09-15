package com.ram.java.designpatterns.objectpool;

import javafx.geometry.Point2D;

/**
 * Represents a Concrete Reusable Product in Object Pool Design Pattern.
 */
public class Bitmap implements Image {

	// Concrete Reusable Product has its own state
	private Point2D location;
	private String name;

	public Bitmap(String name) {
		this.name = name;
	}

	@Override
	public void draw() {
		System.out.println("Drawing " + name + " @ " + location);
	}

	@Override
	public Point2D getLocation() {
		return location;
	}

	@Override
	public void setLocation(Point2D location) {
		this.location = location;
	}

	@Override
	public void reset() {
		this.location = null;
		System.out.println("Bitmap has reset!!");
	}

}

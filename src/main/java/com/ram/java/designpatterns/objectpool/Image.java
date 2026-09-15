package com.ram.java.designpatterns.objectpool;

import javafx.geometry.Point2D;

/**
 * Represents our Abstract Reusable Product in Object Pool Design Pattern.
 */
public interface Image extends Poolable {
	
	void draw();

	Point2D getLocation();

	void setLocation(Point2D location);

}

package com.ram.java.designpatterns.prototype;

/**
 * Swordsman is a Game Unit.
 * This class doesn't support cloning.
 */
public class Swordsman extends GameUnit {
	
	private String state = "idle";

	public void attack() {
		this.state = "attacking";
	}

	@Override
	public String toString() {
		return "Swordsman [state=" + state + " @ " + getPosition() + "]";
	}

	@Override
	protected void reset() {
		this.state = "idle";
	}
}

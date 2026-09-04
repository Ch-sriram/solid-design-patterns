package com.ram.java.solid.interfacesegregation.entities;

import java.time.LocalDateTime;

/**
 * Order Entity containing Order details
 */
public class Order extends Entity {
	
	private LocalDateTime orderPlacedOn;
	
	private double totalValue;

	/**
	 * @return the orderPlacedOn
	 */
	public LocalDateTime getOrderPlacedOn() {
		return orderPlacedOn;
	}

	/**
	 * @param orderPlacedOn the orderPlacedOn to set
	 */
	public void setOrderPlacedOn(LocalDateTime orderPlacedOn) {
		this.orderPlacedOn = orderPlacedOn;
	}

	/**
	 * @return the totalValue
	 */
	public double getTotalValue() {
		return totalValue;
	}

	/**
	 * @param totalValue the totalValue to set
	 */
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

}

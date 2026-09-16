package com.ram.java.designpatterns.adapter;

/**
 * Client code which requires {@link Customer} interface. 
 */
public class BusinessCardDesigner {

	public String designCard(Customer customer) {
		return String.format("%s\n%s\n%s", customer.getName(), customer.getDesignation(), customer.getAddress());
	}

}

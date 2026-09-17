package com.ram.java.designpatterns.decorator;

/**
 * Concrete Component - The Object to be Decorated. 
 */
public class TextMessage implements Message {

	private String message;

	public TextMessage(String message) {
		this.message = message;
	}

	@Override
	public String getContent() {
		return message;
	}

}

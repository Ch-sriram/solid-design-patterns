package com.ram.java.designpatterns.factorymethod.message;

/**
 * Represents a message in text format.
 */
public class TextMessage extends Message {

	@Override
	public String getContent() {
		return "TextMessage";
	}

}

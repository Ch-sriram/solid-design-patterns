package com.ram.java.designpatterns.factorymethod.message;

/**
 * Represents a message in JSON format.
 */
public class JSONMessage extends Message {

	@Override
	public String getContent() {
		return "{\"JSON]\":[]}";
	}

}

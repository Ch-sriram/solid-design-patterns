package com.ram.java.designpatterns.factorymethod.message;

/**
 * Represents a message object.
 */
public abstract class Message {

	/**
	 * To be implemented by the extending classes
	 * @return
	 */
	public abstract String getContent();

	public void addDefaultHeaders() {
		// Adds some default headers.
	}

	public void encrypt() {
		// Has some code to encrypt the content of the message.
	}
}

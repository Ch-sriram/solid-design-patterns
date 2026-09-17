package com.ram.java.designpatterns.decorator;

import java.util.Base64;

/**
 * Decorator, implements {@link Message} component.
 */
public class Base64EncodedMessage implements Message {

	private Message message;

	public Base64EncodedMessage(Message message) {
		this.message = message;
	}

	@Override
	public String getContent() {
		// charset (character set) used in Base64 encoding is platform dependent.
		return Base64.getEncoder().encodeToString(message.getContent().getBytes());
	}

}

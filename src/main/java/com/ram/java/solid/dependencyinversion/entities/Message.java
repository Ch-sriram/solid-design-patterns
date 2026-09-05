package com.ram.java.solid.dependencyinversion.entities;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Represents a message with a timestamp.
 */
public class Message {

	private String message;
	
	private LocalDateTime timestamp;

	public Message(String message) {
		this.message = message;
		this.timestamp = LocalDateTime.now(ZoneId.of("UTC"));
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}

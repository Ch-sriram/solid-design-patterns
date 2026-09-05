package com.ram.java.solid.dependencyinversion;

import com.ram.java.solid.dependencyinversion.entities.Message;
import com.ram.java.solid.dependencyinversion.exceptions.FormatException;

/**
 * Formats given {@link Message} object and assumes a textual formatting.
 */
public class TextFormatter implements Formatter {

	@Override
	public String format(Message message) throws FormatException {
		return message.getTimestamp() + ":" + message.getMessage();
	}
}

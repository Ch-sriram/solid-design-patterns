package com.ram.java.solid.dependencyinversion.services.resolved;

import java.io.PrintWriter;

import com.ram.java.solid.dependencyinversion.Formatter;
import com.ram.java.solid.dependencyinversion.entities.Message;
import com.ram.java.solid.dependencyinversion.exceptions.FormatException;

/**
 * Prints {@link Message} object using {@link Formatter} and {@link PrintWriter} objects. 
 */
public class MessagePrinter {

	// DI Violation RESOLVED: This method doesn't assume any 
	public void writeMessage(Message message, Formatter formatter, PrintWriter writer) throws FormatException {
		writer.println(formatter.format(message));
		writer.flush();
	}
}

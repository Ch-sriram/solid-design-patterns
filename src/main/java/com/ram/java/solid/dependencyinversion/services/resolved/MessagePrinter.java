package com.ram.java.solid.dependencyinversion.services.resolved;

import java.io.PrintWriter;

import com.ram.java.solid.dependencyinversion.Formatter;
import com.ram.java.solid.dependencyinversion.entities.Message;
import com.ram.java.solid.dependencyinversion.exceptions.FormatException;

/**
 * Prints {@link Message} object using {@link Formatter} and {@link PrintWriter} objects. 
 */
public class MessagePrinter {

	// DI Violation RESOLVED: This method doesn't create any tight coupling with Formatter & PrintWriter objects.
	// 						  Both Formatter, and PrintWriter objects are being sent by the caller, and therefore,
	//						  this specific method is now only responsible for writing the message using the
	//						  provided formatter and writer objects.
	public void writeMessage(Message message, Formatter formatter, PrintWriter writer) throws FormatException {
		writer.println(formatter.format(message));
		writer.flush();
	}
}

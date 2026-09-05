package com.ram.java.solid.dependencyinversion.violation.services;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.ram.java.solid.dependencyinversion.entities.Message;
import com.ram.java.solid.dependencyinversion.violation.Formatter;
import com.ram.java.solid.dependencyinversion.violation.JsonFormatter;

/**
 * Prints the given {@link Message} object. 
 */
public class MessagePrinter {

	// DI Principle Violation in Action: This method creates 2 dependencies - JsonFormatter & Writer objects.
	public void writeMessage(Message message, String fileName) throws IOException {
		Formatter formatter = new JsonFormatter();											// Creates a Formatter object     (Dependency)
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {				// Creates a PrintWriter object   (Dependency)
			writer.println(formatter.format(message));										// Formats and writes the message
			writer.flush();
		}
	}
}

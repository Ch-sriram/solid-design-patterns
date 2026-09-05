package com.ram.java.solid.dependencyinversion;

import java.io.IOException;

import com.ram.java.solid.dependencyinversion.entities.Message;
import com.ram.java.solid.dependencyinversion.services.violation.MessagePrinter;

/**
 * Driver program for showing the violation of DI principle. 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		Message message = new Message("This is a message");
		MessagePrinter printer = new MessagePrinter();
		printer.writeMessage(message, "message-print-test.txt");
	}

}

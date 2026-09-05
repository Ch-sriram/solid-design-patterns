package com.ram.java.solid.dependencyinversion.services.resolved;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.ram.java.solid.dependencyinversion.Formatter;
import com.ram.java.solid.dependencyinversion.JsonFormatter;
import com.ram.java.solid.dependencyinversion.TextFormatter;
import com.ram.java.solid.dependencyinversion.entities.Message;

/**
 * Driver program for showing the violation of DI principle. 
 */
public class Main {
	private static final String FILE_NAME = "message-print-test-2.txt";
	private static final String MESSAGE_DISK = "This is another message!";
	private static final String MESSAGE_STD_OUT = "This will print to standard output stream";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		MessagePrinter printer = new MessagePrinter();

		/**
		 * Formatter objects defined once, can be reused as many times as we want now!
		 */
		Formatter jsonFormatter = new JsonFormatter();
		Formatter textFormatter = new TextFormatter();

		/**
		 * Prepared Message objects can be reused as well!
		 */
		Message messageDisk = new Message(MESSAGE_DISK);
		Message messageStandardOut = new Message(MESSAGE_STD_OUT);

		/**
		 * The main method, which is the caller of MessagePrinter::writeMessage,
		 * is providing the dependencies for Message Printer, and can control
		 * what kind of instance it sends, thereby ensuring that the exact
		 * implementation of the instance passed onto MessagePrinter::writeMessage,
		 * is only known to main method, and also, it can now send a different
		 * Formatter object, or a different place to write to, if it wants.
		 */
		
		// SCENARIO 1: JSON Formatting + Write Message to Disk
		try (PrintWriter writerToDisk = new PrintWriter(new FileWriter(FILE_NAME))) {
			printer.writeMessage(messageDisk, jsonFormatter, writerToDisk);			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// SCENARIO 2: Text Formatting + Write Message to Standard Output Stream (stdout is memory)
		// If the writer is defined inside try-with-resources, then since PrintWriter is AutoCloseable,
		// writer.close() internally, also closes System.out's stream, and therefore,
		// SCENARIO 3 below won't be executed below.
		PrintWriter writerToStandardOutput = new PrintWriter(System.out);
		try {
			printer.writeMessage(messageStandardOut, textFormatter, writerToStandardOutput);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// SCENARIO 3: JSON Formatting + Write Message to stdout
		writerToStandardOutput = new PrintWriter(System.out);
		try {
			printer.writeMessage(messageStandardOut, jsonFormatter, writerToStandardOutput);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// SCENARIO 4: Text Formatting + Write to Disk
		try (PrintWriter writerToDisk = new PrintWriter(new FileWriter(FILE_NAME))) {
			printer.writeMessage(messageStandardOut, textFormatter, writerToDisk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

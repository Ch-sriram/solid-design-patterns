package com.ram.java.solid.dependencyinversion.exceptions;

import java.io.IOException;

/**
 * Custom Exception thrown by the Formatter.
 */
public class FormatException extends IOException {

	private static final long serialVersionUID = -7289125813800512911L;

	public FormatException(Exception cause) {
		super(cause);
	}
}

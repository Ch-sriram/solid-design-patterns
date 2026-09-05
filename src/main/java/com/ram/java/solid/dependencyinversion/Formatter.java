package com.ram.java.solid.dependencyinversion;

import com.ram.java.solid.dependencyinversion.entities.Message;
import com.ram.java.solid.dependencyinversion.exceptions.FormatException;

/**
 * Defines behaviour for classes formatting {@link Message} object.
 */
public interface Formatter {

	public String format(Message message) throws FormatException;
}

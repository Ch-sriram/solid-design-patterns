package com.ram.java.solid.dependencyinversion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ram.java.solid.dependencyinversion.entities.Message;
import com.ram.java.solid.dependencyinversion.exceptions.FormatException;

/**
 * Formats JSON data receiving {@link Message} object. 
 */
public class JsonFormatter implements Formatter {

	@Override
	public String format(Message message) throws FormatException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(message);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new FormatException(e);
		}
	}
}

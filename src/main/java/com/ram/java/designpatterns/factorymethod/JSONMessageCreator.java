package com.ram.java.designpatterns.factorymethod;

import com.ram.java.designpatterns.factorymethod.message.JSONMessage;
import com.ram.java.designpatterns.factorymethod.message.Message;

/**
 * Creates {@link JSONMessage} object.
 */
public class JSONMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		return new JSONMessage();
	}

}

package com.ram.java.designpatterns.factorymethod;

import com.ram.java.designpatterns.factorymethod.message.Message;
import com.ram.java.designpatterns.factorymethod.message.TextMessage;

/**
 * Creates {@link TextMessage} object.
 */
public class TextMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		return new TextMessage();
	}

}

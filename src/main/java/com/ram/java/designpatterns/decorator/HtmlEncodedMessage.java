package com.ram.java.designpatterns.decorator;

import org.apache.commons.text.StringEscapeUtils;

/**
 * Decorator, implements {@link Message} component interface. 
 */
public class HtmlEncodedMessage implements Message {
	
	private Message message;

	public HtmlEncodedMessage(Message message) {
		this.message = message;
	}

	@Override
	public String getContent() {
		// We're adding onto the original message's getContent()'s returned String dynamically. This is precisely what a decorator is doing.
		return StringEscapeUtils.escapeHtml4(message.getContent());
	}

}

package com.ram.java.designpatterns.factorymethod;

import com.ram.java.designpatterns.factorymethod.message.Message;

/**
 * This is the abstract "creator".
 * 
 * @implNote
 * The abstract method `createMessage()` has to be
 * implemented by the sub-classes of this abstract class. 
 */
public abstract class MessageCreator {
	
	public Message getMessage() {
		Message message = createMessage();

		message.addDefaultHeaders();
		message.encrypt();

		return message;
	}

	/**
	 * Has to be implemented by the concrete creators for {@link Message} object instance(s).
	 * @return
	 */
	public abstract Message createMessage();

}

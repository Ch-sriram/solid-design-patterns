package com.ram.java.designpatterns.factorymethod;

import com.ram.java.designpatterns.factorymethod.message.Message;

/**
 * Driver program that runs that demonstrates the Factory Method pattern. 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printMessage(new JSONMessageCreator());
		printMessage(new TextMessageCreator());
	}

	/**
	 * Prints the {@link Message} object that's created using a {@link MessageCreator}.
	 *
	 * @param creator
	 */
	public static void printMessage(MessageCreator creator) {
		Message message = creator.getMessage();
		System.out.println(message.getContent());
	}
	
	/**
	 * Output:
	 * ------
	 * 
	 * {"JSON]":[]}
	 * TextMessage
	 */
}

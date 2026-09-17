package com.ram.java.designpatterns.decorator;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Driver Program that Demonstrates the Usage of Decorator Design Pattern. 
 */
public class Client {

	public static void main(String[] args) {
		// Without using Decorator
		Message message = new TextMessage("The <FORCE> is strong with this one!");
		System.out.println(message.getContent());                                          // O/P: The <FORCE> is strong with this one!

		// When using HtmlEncodedMessage Decorator
		Message decorator = new HtmlEncodedMessage(message);
		System.out.println(decorator.getContent());                                        // O/P: The &lt;FORCE&gt; is strong with this one!

		// When using Base64EncodedMessage Decorator
		Message decorator2 = new Base64EncodedMessage(message);
		System.out.println(decorator2.getContent());                                       // O/P: VGhlIDxGT1JDRT4gaXMgc3Ryb25nIHdpdGggdGhpcyBvbmUh
		
		byte[] decodedStringInBytes = Base64.getDecoder().decode(decorator2.getContent());
		System.out.println(new String(decodedStringInBytes, StandardCharsets.UTF_8));      // O/P: The <FORCE> is strong with this one!
	}

}

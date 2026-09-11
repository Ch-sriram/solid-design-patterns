package com.ram.java.designpatterns.abstractfactory.documentbuilderfactoryexample;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

/**
 * Demonstrates the {@link DocumentBuilderFactory} Abstract Factory Pattern. 
 */
public class ClientWithOfficialXmlParser {

	public static void main(String[] args) throws ParserConfigurationException {
		// DocumentBuilderFactory.newInstance() is a static field, which isn't according
		// to the GoF's Abstract Factory's design pattern definition.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		System.out.println("Using factory class: " + factory.getClass());

		// But the internal implementation of the actual factory instance, is exactly as
		// mentioned in GoF's Abstract Factory design pattern definition.
		DocumentBuilder builder = factory.newDocumentBuilder();
		System.out.println("Got Builder class: " + builder.getClass());

		Document doc = builder.newDocument();
		System.out.println("Got document class: " + doc.getClass());
	}

	/**
	 * Output:
	 * -------
	 * 
	 * Using factory class: class com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl
     * Got Builder class: class com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderImpl
     * Got document class: class com.sun.org.apache.xerces.internal.dom.DocumentImpl
	 */
}

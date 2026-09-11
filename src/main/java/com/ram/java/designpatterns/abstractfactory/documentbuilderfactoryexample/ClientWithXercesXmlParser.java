package com.ram.java.designpatterns.abstractfactory.documentbuilderfactoryexample;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

/**
 * Demonstrates the {@link DocumentBuilderFactory} Abstract Factory Pattern.
 *
 * @apiNote the Run Configuration is set to make use of Apache Xerces' JAR
 * during runtime to make use of a different {@link DocumentBuilder}, all
 * wired during runtime. The JAR itself can be downloaded from:
 * https://mvnrepository.com/artifact/org.apache.xerces/org.apache.xerces/2.12.2
 * 
 * @implNote The actual JAR being used is located at: {@linkplain lib/xercesImpl-2.12.2.jar}
 * 
 * How to configure?
 * <li>
 *   <ol>Right-click on this file > Run as > Run Configurations... > Dependencies</ol>
 *   <ol>Add the JAR in /lib/xercersImpl.jar</ol>
 * </li>
 * 
 * Then just run the code, and see the difference in the output, compared to how it ran in
 * {@link ClientWithOfficialXmlParser}.
 */
public class ClientWithXercesXmlParser {

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
	 * As you can see here, the output is different here, compared to
	 * {@link ClientWithOfficialXmlParser}.
	 *
	 * Output:
	 * -------
	 *
	 * Using factory class: class org.apache.xerces.jaxp.DocumentBuilderFactoryImpl
     * Got Builder class: class org.apache.xerces.jaxp.DocumentBuilderImpl
     * Got document class: class org.apache.xerces.dom.DocumentImpl
	 */
}

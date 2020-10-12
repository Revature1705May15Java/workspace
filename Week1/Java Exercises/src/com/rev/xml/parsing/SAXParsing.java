package com.rev.xml.parsing;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParsing {


	public static void main(String[] args) throws Exception{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sax = spf.newSAXParser();





		DefaultHandler handler = new DefaultHandler() {

			boolean fn = false;
			boolean ln = false;
			boolean age = false;

			public void startElement(String uri, String localName,String qName,
					Attributes attributes) throws SAXException {

				System.out.println("Start Element :" + qName);

				if (qName.equalsIgnoreCase("FIRSTNAME")) {
					fn = true;
				}

				if (qName.equalsIgnoreCase("LASTNAME")) {
					ln = true;
				}

				if (qName.equalsIgnoreCase("AGE")) {
					age = true;
				}


			}

			public void endElement(String uri, String localName,
					String qName) throws SAXException {

				System.out.println("End Element :" + qName);

			}

			public void characters(char ch[], int start, int length) throws SAXException {

				if (fn) {
					System.out.println("First Name : " + new String(ch, start, length));
					fn= false;
				}

				if (ln) {
					System.out.println("Last Name : " + new String(ch, start, length));
					ln = false;
				}

				if (age) {
					System.out.println("Age : " + new String(ch, start, length));
					age = false;
				}


			}

		};
		
		sax.parse("src/com/rev/xml/sample.xml", handler);
	}


}
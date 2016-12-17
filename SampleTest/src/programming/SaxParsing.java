package programming;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SaxParsing {

	public static void main(String args[]) {

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxpaser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean fName = false;
				boolean lName = false;
				boolean address = false;
				boolean salary = false;

				/* Start Element */
				public void startElement(String uri, String localName,
						String qName, Attributes attributes) {

					System.out.println("Start Element..> " + qName);

					if (qName.equalsIgnoreCase("firstName")) {
						fName = true;
					}

					else if (qName.equalsIgnoreCase("lastName")) {
						lName = true;
					}

					else if (qName.equalsIgnoreCase("address")) {
						address = true;
					}

					else if (qName.equalsIgnoreCase("salary")) {
						salary = true;
					}
				}

				/* End Element */
				public void endElement(String uri, String localName,
						String qName) {
					System.out.println("End Element..> " + qName);
				}

				/* Character */
				public void characters(char ch[], int start, int length) {
					if (fName) {
						System.out.println("First Name..> "
								+ new String(ch, start, length));
						fName = false;
					}

					else if (lName) {
						System.out.println("Last Name..> "
								+ new String(ch, start, length));
						lName = false;
					}

					else if (address) {
						System.out.println("Address..> "
								+ new String(ch, start, length));
						address = false;
					}

					else if (salary) {
						System.out.println("salary..> "
								+ new String(ch, start, length));
						salary = false;
					}
				}
			};

			try {
				InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("/Users/hiteshbhardwaj/Desktop/Automation/workspace/SampleTest/Sax.xml")));
				InputSource sreader = new InputSource(isr);
				sreader.setEncoding("UTF-8");
				saxpaser.parse("Sax.xml", handler);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	}

	/* */
	/*
	 * File file = new
	 * File("/Users/hiteshbhardwaj/Desktop/Automation/workspace/SampleTest/Sax.xml"
	 * ); InputStream stream = new FileInputStream(file); Reader reader = new
	 * InputStreamReader(stream, "UTF-8"); InputSource source_reader = new
	 * InputSource(reader);
	 */
}

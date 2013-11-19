package main.java.me.jackbracken.FYP.FileUtilities;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseUserFile extends DefaultHandler {
	File file;

	public ParseUserFile(File file) {
		this.file = file;
		parseDocument();
	}

	private void parseDocument() {
		// parse
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(file, this);
		} catch (ParserConfigurationException e) {
			System.out.println("ParserConfig error");
		} catch (SAXException e) {
			System.out.println("SAXException : xml not well formed");
		} catch (IOException e) {
			System.out.println("IO error");
		}
	}

	@Override
	public void startElement(String s, String s1, String elementName,
			Attributes attributes) throws SAXException {
		
		if (elementName.equalsIgnoreCase("row")) {
			int userID, reputation, views, downVotes, upVotes, age;
			String displayName, location, aboutText, emailHash, creationDate, lastAccess;

			userID = Integer.parseInt(attributes.getValue("Id"));
			reputation = Integer.parseInt(attributes.getValue("Reputation"));
			creationDate = attributes.getValue("CreationDate");
			displayName = attributes.getValue("DisplayName");
			lastAccess = attributes.getValue("LastAccessDate");
			location = attributes.getValue("Location");
			aboutText = attributes.getValue("AboutMe");
			views = Integer.parseInt(attributes.getValue("Views"));
			upVotes = Integer.parseInt(attributes.getValue("UpVotes"));
			downVotes = Integer.parseInt(attributes.getValue("DownVotes"));
			emailHash = attributes.getValue("EmailHash");
			
			try {
				age = Integer.parseInt(attributes.getValue("Age"));
			} catch (NumberFormatException e) {
				// Age not given
				age = -1;
			}
		}
	}
}

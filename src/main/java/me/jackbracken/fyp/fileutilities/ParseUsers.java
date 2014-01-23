package main.java.me.jackbracken.fyp.fileutilities;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import main.java.me.jackbracken.fyp.models.User;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseUsers extends DefaultHandler {
	File file;
	String site;
	Vector<User> userList = new Vector<User>();

	public ParseUsers(File file, String site) {		
		this.file = file;
		this.site = site;
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

	public Vector<User> getUserList() {
		return userList;
	}
	
	@Override
	public void startElement(String s, String s1, String elementName,
			Attributes attributes) throws SAXException {

		if (elementName.equalsIgnoreCase("row")) {
			int id, reputation;
			String name;

			id = Integer.parseInt(attributes.getValue("Id"));
			reputation = Integer.parseInt(attributes.getValue("Reputation"));
			name = attributes.getValue("DisplayName");
			
			userList.add(new User(id, reputation, name, site));
		}
	}
}

package main.java.me.jackbracken.FYP.FileUtilities;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import main.java.me.jackbracken.FYP.Models.User;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseUserFile extends DefaultHandler {
	Vector<User> users;
	File file;
	String tmpValue;
	User user;

	public ParseUserFile(File file) {
		this.file = file;
		users = new Vector<User>();
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

	public Vector<User> getUsers() {
		return users;
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
			
			try {
				user = new User(userID, reputation, creationDate,
						displayName, lastAccess, location, aboutText, views,
						downVotes, upVotes, emailHash, age);

				users.add(user);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void endElement(String s, String s1, String element)
			throws SAXException {
	}

	@Override
	public void characters(char[] ac, int i, int j) throws SAXException {
		tmpValue = new String(ac, i, j);
	}
}

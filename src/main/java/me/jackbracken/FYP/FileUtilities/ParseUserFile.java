package main.java.me.jackbracken.FYP.FileUtilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import main.java.me.jackbracken.FYP.Models.User;

import org.skife.jdbi.v2.Handle;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseUserFile extends DefaultHandler {
	File file;
	Handle h;
	Vector<User> userList = new Vector<User>();

	public ParseUserFile(File file) {
		 /** PGPoolingDataSource ds = new PGPoolingDataSource();
		 ds.setDataSourceName("fyp");
		 ds.setDatabaseName("fyp");
		 ds.setUser("karma");
		 ds.setPassword("karma");
		 ds.setMaxConnections(3);
		
		 DBI dbi = new DBI(ds);
		 this.h = dbi.open();
		 */
		
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

	public Vector<User> getUserList() {
		return userList;
	}
	
	@Override
	public void startElement(String s, String s1, String elementName,
			Attributes attributes) throws SAXException {

		if (elementName.equalsIgnoreCase("row")) {
			int id;
			short reputation;
			String name;

			id = Integer.parseInt(attributes.getValue("Id"));
			reputation = Short.parseShort(attributes.getValue("Reputation"));
			name = attributes.getValue("DisplayName");

			userList.add(new User(id, reputation, name));


			// h.execute("insert into users values " +
			// userID + "," +
			// reputation + "," +
			// creationDateString + "," +
			// displayName + "," +
			// lastAccess + "," +
			// location + "," +
			// aboutText + "," +
			// views + "," +
			// upVotes + "," +
			// downVotes + "," +
			// emailHash + "," +
			// age
			// );
		}
	}
}

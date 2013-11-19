package main.java.me.jackbracken.FYP.FileUtilities;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseVoteFile extends DefaultHandler {
	File file;

	public ParseVoteFile(File file) {
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
			int voteID, postID, voteTypeID;
			String creationDate;

			voteID = Integer.parseInt(attributes.getValue("Id"));
			postID = Integer.parseInt(attributes.getValue("PostId"));
			voteTypeID = Integer.parseInt(attributes.getValue("VoteTypeId"));
			creationDate = attributes.getValue("CreationDate");
		}
	}
}

package main.java.me.jackbracken.FYP.FileUtilities;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParsePostFile extends DefaultHandler {
	File file;

	public ParsePostFile(File file) {
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
			int postID, postTypeID, acceptedAnswerID, score, ownerUserID, answerCount, favoriteCount;
			String body, title, tags, creationDate;

			postID = Integer.parseInt(attributes.getValue("Id"));
			postTypeID = Integer.parseInt(attributes.getValue("PostTypeId"));
			creationDate = attributes.getValue("CreationDate");
			score = Integer.parseInt(attributes.getValue("Score"));
			body = attributes.getValue("Body");
			title = attributes.getValue("Title");
			tags = attributes.getValue("Tags");
			
			try {
				acceptedAnswerID = Integer.parseInt(attributes.getValue("AcceptedAnswerId"));
			} catch (NumberFormatException e) {
				// No accepted answer or the post is not a question
				acceptedAnswerID = -1;
			}
			
			try {			
				ownerUserID = Integer.parseInt(attributes.getValue("OwnerUserId"));
			} catch (NumberFormatException e) {
				// Owner account no longer exists
				ownerUserID = -1;
			}
			
			try {
				answerCount = Integer.parseInt(attributes.getValue("AnswerCount"));
			} catch (NumberFormatException e) {
				// Not a queestion, does not have answers
				answerCount = -1;
			}
			
			try {
				favoriteCount = Integer.parseInt(attributes.getValue("FavoriteCount"));
			} catch (NumberFormatException e) {
				favoriteCount = 0;
			}
		}
	}
}

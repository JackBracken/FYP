package main.java.me.jackbracken.FYP.FileUtilities;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import main.java.me.jackbracken.FYP.Models.Post;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParsePostFile extends DefaultHandler {
	Vector<Post> posts;
	File file;
	String tmpValue;
	Post post;

	public ParsePostFile(File file) {
		this.file = file;
		posts = new Vector<Post>();
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

	public Vector<Post> getPosts() {
		return posts;
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
			
			try {
				post = new Post(postID, postTypeID, acceptedAnswerID,
						creationDate, score, body,
						ownerUserID, title, tags,
						answerCount, favoriteCount);

				posts.add(post);
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

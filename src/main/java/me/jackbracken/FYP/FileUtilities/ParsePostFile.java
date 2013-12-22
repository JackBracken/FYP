package main.java.me.jackbracken.FYP.FileUtilities;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import main.java.me.jackbracken.FYP.Models.Post;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParsePostFile extends DefaultHandler {
	File file;
	Vector<Post> postList = new Vector<Post>();

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

	public Vector<Post> getPostList() {
		return postList;
	}

	@Override
	public void startElement(String s, String s1, String elementName,
			Attributes attributes) throws SAXException {

		if (elementName.equalsIgnoreCase("row")) {
			int id, acceptedAnswer, ownerID;
			byte postTypeID;
			short score, answers;
			String creationDate;

			id = Integer.parseInt(attributes.getValue("Id"));
			postTypeID = Byte.parseByte(attributes.getValue("PostTypeId"));
			creationDate = attributes.getValue("CreationDate");
			score = Short.parseShort(attributes.getValue("Score"));

			try {
				acceptedAnswer = Integer.parseInt(
					attributes.getValue("AcceptedAnswerId")
				);
				
			} catch (NumberFormatException e) {
				// No accepted answer or the post is not a question
				acceptedAnswer = -1;
			}

			try {
				ownerID = Integer.parseInt(
					attributes.getValue("OwnerUserId")
				);
				
			} catch (NumberFormatException e) {
				// Owner account no longer exists
				ownerID = -1;
			}

			try {
				answers = Short.parseShort(
					attributes.getValue("AnswerCount")
				);
				
			} catch (NumberFormatException e) {
				// Not a queestion, does not have answers
				answers = -1;
			}

			try {
				postList.add(new Post(id, postTypeID, acceptedAnswer,
						creationDate, score, ownerID, answers));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}

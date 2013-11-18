package main.java.me.jackbracken.FYP.FileUtilities;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import main.java.me.jackbracken.FYP.Models.Vote;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseVoteFile extends DefaultHandler {
	Vector<Vote> votes;
	File file;
	String tmpValue;
	Vote vote;

	public ParseVoteFile(File file) {
		this.file = file;
		votes = new Vector<Vote>();
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

	public Vector<Vote> getVotes() {
		return votes;
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
			
			try {
				vote = new Vote(voteID, postID, voteTypeID, creationDate);
				votes.add(vote);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

//	@Override
//	public void endElement(String s, String s1, String element)
//			throws SAXException {
//	}

//	@Override
//	public void characters(char[] ac, int i, int j) throws SAXException {
//		tmpValue = new String(ac, i, j);
//	}

}

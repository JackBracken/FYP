package main.java.me.jackbracken.fyp.fileutilities;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import main.java.me.jackbracken.fyp.models.Answer;
import main.java.me.jackbracken.fyp.models.Post;
import main.java.me.jackbracken.fyp.models.Question;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParsePosts extends DefaultHandler {
	File file;
	String site;
	Vector<Question> questionList = new Vector<Question>();
	Vector<Answer> answerList = new Vector<Answer>();

	public ParsePosts(File file, String site) {
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

	public Vector<Answer> getAnswerList() {
		return answerList;
	}
	
	public Vector<Question> getQuestionList() {
		return questionList;
	}
	
	@Override
	public void startElement(String s, String s1, String elementName,
			Attributes attributes) throws SAXException {

		if (elementName.equalsIgnoreCase("row")) {
			int id, acceptedAnswer, ownerID, parentID;
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
				// Not a question, does not have answers
				answers = -1;
			}
			
			try {
				parentID = Integer.parseInt(
						attributes.getValue("ParentId")
				);
			} catch (NumberFormatException e) {
				// Not an answer, does not have a parent
				parentID = -1;
			}
			
			if(postTypeID == 1) {
				 questionList.add(new Question(id, ownerID, site)); 
			} else if(postTypeID == 2) {
				if (id <  20){
					System.out.println("id: " + id + " parent: " + parentID);
				}
				answerList.add(new Answer(id, ownerID, parentID, score, site));
				
			} 
		}
	}
}

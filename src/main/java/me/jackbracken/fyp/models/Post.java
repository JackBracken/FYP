package main.java.me.jackbracken.fyp.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
	// The date format used by StackExchange
	SimpleDateFormat stackTimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'H:m:s'.'S");

	int id, acceptedAnswer, ownerID;
	byte postTypeID;
	short score, answers;
	Date creationDate;
	String site;

	public Post(int id, byte postTypeID, int acceptedAnswer,
			String creationDate, short score, int ownerID, short answers, String site)
			throws ParseException {

		this.id = id;
		this.postTypeID = postTypeID;
		this.acceptedAnswer = acceptedAnswer;
		this.creationDate = stackTimeFormat.parse(creationDate);
		this.score = score;
		this.ownerID = ownerID;
		this.answers = answers;
		this.site = site;
	}

	public int getID() {
		return id;
	}

	public byte getPostTypeID() {
		return postTypeID;
	}

	public int getAcceptedAnswer() {
		return acceptedAnswer;
	}

	public short getScore() {
		return score;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public short getAnswerCount() {
		return answers;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	
	public String getSite() {
		return site;
	}

	public String toString() {
		return "ID: " + id + ",\tScore: " + score + ",\tCreation Date: "
				+ creationDate;
	}
}

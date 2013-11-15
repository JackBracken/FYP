package main.java.me.jackbracken.FYP.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
	// The date format used by StackExchange
	SimpleDateFormat stackTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'H:m:s'.'S");

	int postID, postTypeID, acceptedAnswerID, score, ownerUserID, answerCount, favoriteCount;
	Date creationDate;
	String body, title, tags;
	
	public Post(int postID, int postTypeID, int acceptedAnswerID,
			String creationDate, int score, String body,
			int ownerUserID, String title, String tags,
			int answerCount, int favoriteCount) throws ParseException {

		this.postID = postID;
		this.postTypeID = postTypeID;
		this.acceptedAnswerID = acceptedAnswerID;
		this.creationDate = stackTimeFormat.parse(creationDate);
		this.score = score;
		this.body = body;
		this.ownerUserID = ownerUserID;
		this.title = title;
		this.tags = tags;
		this.answerCount = answerCount;
		this.favoriteCount = favoriteCount;
	}

	public int getPostID() {
		return postID;
	}

	public int getPostTypeID() {
		return postTypeID;
	}

	public int getAcceptedAnswerID() {
		return acceptedAnswerID;
	}

	public int getScore() {
		return score;
	}

	public int getOwnerUserID() {
		return ownerUserID;
	}

	public int getAnswerCount() {
		return answerCount;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public String getBody() {
		return body;
	}

	public String getTitle() {
		return title;
	}

	public String getTags() {
		return tags;
	}

	public String toString() {
		return "ID: " + postID + ",\tType: " + score  + ",\tCreation Date: "
				+ creationDate;
	}
}

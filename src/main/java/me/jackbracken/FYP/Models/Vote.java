package main.java.me.jackbracken.FYP.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vote {
	// The date format used by StackExchange
	SimpleDateFormat stackTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'H:m:s'.'S");

	int voteID, postID, voteTypeID;
	Date creationDate;

	public Vote(int voteID, int postID, int voteTypeID, String creationDate) throws ParseException {
		this.voteID = voteID;
		this.postID = postID;
		this.voteTypeID = voteTypeID;
		this.creationDate = stackTimeFormat.parse(creationDate);
	}

	public int getVoteID() {
		return voteID;
	}

	public int getPostID() {
		return postID;
	}

	public int getVoteTypeID() {
		return voteTypeID;
	}

	public Date getCreationDate() {
		return creationDate;
	}
}

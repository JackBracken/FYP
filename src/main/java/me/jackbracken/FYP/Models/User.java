package main.java.me.jackbracken.FYP.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	// The date format used by StackExchange
	SimpleDateFormat toUnixTime = new SimpleDateFormat("yyyy-MM-dd'T'H:m:s'.'S");

	int userID, reputation, views, downVotes, upVotes, age;
	Date creationDate, lastAccess;
	String displayName, location, aboutText, emailHash;
	
	public User(int userID, int reputation, String creationDate, String displayName, String lastAccess,
			String location, String aboutText, int views, int downVotes, int upVotes, String emailHash, int age) throws ParseException {
		
		this.userID 		= userID;
		this.reputation 	= reputation;
		this.creationDate 	= toUnixTime.parse(creationDate);
		this.displayName 	= displayName;
		this.lastAccess		= toUnixTime.parse(lastAccess);
		this.location 		= location;
		this.aboutText 		= aboutText;
		this.views 			= views;
		this.downVotes 		= downVotes;
		this.upVotes 		= upVotes;
		this.emailHash 		= emailHash;
		this.age 			= age;
	}
	
	public String toString() {
		return "ID: " + userID + "\tName: " + displayName + "\tReputation: " + reputation;
	}

	private int getUserId() {
		return userID;
	}

	private int getReputation() {
		return reputation;
	}

	private Date getCreationDate() {
		return creationDate;
	}

	private String getDisplayName() {
		return displayName;
	}

	private String getLocation() {
		return location;
	}

	private int getViews() {
		return views;
	}

	private int getUpVotes() {
		return upVotes;
	}

	private int getDownVotes() {
		return downVotes;
	}

}

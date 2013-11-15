package main.java.me.jackbracken.FYP.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	// The date format used by StackExchange
	SimpleDateFormat stackTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'H:m:s'.'S");

	int userID, reputation, views, downVotes, upVotes, age;
	Date creationDate, lastAccess;
	String displayName, location, aboutText, emailHash;
	
	public User(int userID, int reputation, String creationDate,
			String displayName, String lastAccess, String location,
			String aboutText, int views, int downVotes, int upVotes,
			String emailHash, int age) throws ParseException {

		this.userID = userID;
		this.reputation = reputation;
		this.creationDate = stackTimeFormat.parse(creationDate);
		this.displayName = displayName;
		this.lastAccess = stackTimeFormat.parse(lastAccess);
		this.location = location;
		this.aboutText = aboutText;
		this.views = views;
		this.downVotes = downVotes;
		this.upVotes = upVotes;
		this.emailHash = emailHash;
		this.age = age;
	}

	public String toString() {
		String r = "", u = "";
		if(reputation < 100)
			r = "\t";
		if (upVotes < 100)
			u = "\t";

		return "ID: " + userID + ",\tReputation: " + reputation + ","  + r + "\tUp: "
				+ upVotes + "," + u + "\tDown: " + downVotes + ",\tName: " + displayName;
	}

	public int getUserId() {
		return userID;
	}

	public int getReputation() {
		return reputation;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getLocation() {
		return location;
	}

	public int getViews() {
		return views;
	}

	public int getUpVotes() {
		return upVotes;
	}

	public int getDownVotes() {
		return downVotes;
	}

}

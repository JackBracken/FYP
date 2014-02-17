package main.java.me.jackbracken.fyp.models;

public class Question {
	int id, ownerID;
	String site;
	
	public Question(int id, int ownerID, String site) {
		this.id = id;
		this.ownerID = ownerID;
		this.site = site;
	}
	
	public int getID() {
		return id;
	}
	
	public int getOwnerID() {
		return ownerID;
	}

	public String getSite() {
		return site;
	}

	public String toString() {
		return "ID:  " + id + " owner ID: " + ownerID;
	}
}

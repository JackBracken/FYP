package main.java.me.jackbracken.fyp.models;

public class Question {
	int id, ownerId;
	String site;
	
	public Question(int id, int ownerId, String site) {
		this.id = id;
		this.ownerId = ownerId;
		this.site = site;
	}
	
	public int getId() {
		return id;
	}
	
	public int getOwnerId() {
		return ownerId;
	}

	public String getSite() {
		return site;
	}
}

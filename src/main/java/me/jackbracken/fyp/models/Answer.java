package main.java.me.jackbracken.fyp.models;

public class Answer {
	int id, ownerID, parentID, score;
	String site;
	
	public Answer(int id, int ownerID, int parentID, int score, String site) {
		this.id = id;
		this.ownerID = ownerID;
		this.parentID = parentID;
		this.score = score;
		this.site = site;
	}
	
	public int getID() {
		return id;
	}
	
	public int getOwnerID() {
		return ownerID;
	}
	
	public int getParentID() {
		return parentID;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getSite() {
		return site;
	}
		
	public String toString() {
		return "ID:  " + id + " owner ID: " + ownerID + " parent ID: " + parentID + " score: " + score;
	}
}

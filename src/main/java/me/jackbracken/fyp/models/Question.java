package main.java.me.jackbracken.fyp.models;

public class Question {
	int id, ownerID, index;
	String site;
	int[] answerIDs;
	
	public Question(int id, int ownerID, int numberOfAnswers, String site) {
		this.id = id;
		this.ownerID = ownerID;
		this.site = site;
		answerIDs = new int[numberOfAnswers];
		index = 0;
	}
	
	public void addAnswer(int id) {
		answerIDs[index] = id;
		index++;
	}
	
	public int[] getAnswers() {
		return answerIDs;
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

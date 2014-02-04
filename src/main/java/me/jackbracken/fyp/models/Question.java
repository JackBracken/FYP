package main.java.me.jackbracken.fyp.models;

public class Question {
	int id, ownerId;
	int[] answers;
	String site;
	
	public Question(int id, int ownerId, int[] answers, String site) {
		this.id = id;
		this.ownerId = ownerId;
		this.answers = answers;
		this.site = site;
	}
	
	public int getId() {
		return id;
	}
	
	public int getOwnerId() {
		return ownerId;
	}
	
	public int[] getAnswers() {
		return answers;
	}

	public String getSite() {
		return site;
	}
}

package main.java.me.jackbracken.fyp.models;

public class Answer {
	int id, ownerId, parentId, score;
	String site;
	
	public Answer(int id, int ownerId, int parentId, int score, String site) {
		this.id = id;
		this.ownerId = ownerId;
		this.parentId = parentId;
		this.score = score;
		this.site = site;
	}
	
	public int getId() {
		return id;
	}
	
	public int getOwnerId() {
		return ownerId;
	}
	
	public int getParentId() {
		return parentId;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getSite() {
		return site;
	}
	
}

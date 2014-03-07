package main.java.me.jackbracken.fyp.models;

public class User {
	int id, stackReputation;
	String name, site;
	double weightedSumScore;
	
	public User(int id, int stackReputation, String name, String site) {
		this.id = id;
		this.stackReputation = stackReputation;
		this.name = name;
		this.site = site;
		
		weightedSumScore = 0.0;
	}
	
	public void increaseWS(double r) {
		weightedSumScore += r;
	}
	
	public double getWS() {
		return weightedSumScore;
	}

	public String toString() {
		return "id: " + id + " \trep" + stackReputation + " \tname: " + name;
	}

	public int getUserId() {
		return id;
	}

	public int getStackReputation() {
		return stackReputation;
	}

	public String getName() {
		return name;
	}
	
	public String getSite() {
		return site;
	}
}

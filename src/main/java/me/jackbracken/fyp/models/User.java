package main.java.me.jackbracken.fyp.models;

public class User {
	int id, reputation;
	String name, site;
	
	public User(int id, int reputation, String name, String site) {
		this.id = id;
		this.reputation = reputation;
		this.name = name;
		this.site = site;
	}

	public String toString() {
		return "id: " + id + " \trep" + reputation + " \tname: " + name;
	}

	public int getUserId() {
		return id;
	}

	public int getReputation() {
		return reputation;
	}

	public String getName() {
		return name;
	}
	
	public String getSite() {
		return site;
	}
}

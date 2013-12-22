package main.java.me.jackbracken.FYP.Models;

public class User {
	int id;
	short reputation;
	String name;
	
	public User(int id, short reputation, String name) {
		this.id = id;
		this.reputation = reputation;
		this.name = name;
	}

	public String toString() {
		return "id: " + id + " \trep" + reputation + " \tname: " + name;
	}

	public int getUserId() {
		return id;
	}

	public short getReputation() {
		return reputation;
	}

	public String getName() {
		return name;
	}
}

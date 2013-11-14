package main.java.me.jackbracken.FYP;

import java.io.File;
import java.util.Vector;

import main.java.me.jackbracken.FYP.FileUtilities.ParseUserFile;
import main.java.me.jackbracken.FYP.Models.User;

import com.googlecode.flyway.core.Flyway;

public class FYP {
	public static void main(String[] args) {
		// Create flyway instance
		Flyway flyway = new Flyway();
		// Point to database
		flyway.setDataSource("jdbc:postgresql:fyp", "karma", "karma");
		flyway.migrate();

		File file = new File("/home/jack/stack/Users.xml");

		ParseUserFile puf = new ParseUserFile(file);
		Vector<User> users = new Vector<User>(puf.getUsers());
		for(User u: users) {
			System.out.println(u.toString());
		}
		System.exit(0);
	}
}

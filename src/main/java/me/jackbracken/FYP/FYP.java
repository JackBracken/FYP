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
		flyway.setDataSource("jdbc:postgresql:fyp", "postgres", "october");
		flyway.migrate();

		File file = new File("/home/jack/stack/Users.xml");

		ParseUserFile puf = new ParseUserFile(file);
		Vector<Vector<User>> users = new Vector<Vector<User>>(puf.getUsers());
		User first = users.firstElement().firstElement();
//		System.out.println(users.lastElement());
		System.exit(0);
	}
}

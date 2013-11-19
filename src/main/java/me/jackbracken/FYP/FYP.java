package main.java.me.jackbracken.FYP;

import java.io.File;

import main.java.me.jackbracken.FYP.FileUtilities.ParserLauncher;

import com.googlecode.flyway.core.Flyway;

public class FYP {
	public static void main(String[] args) {
		// Create flyway instance
		Flyway flyway = new Flyway();
		// Point to database
		flyway.setDataSource("jdbc:postgresql:fyp", "karma", "karma");
		flyway.migrate();

		final String HOME = System.getenv("HOME");
		
		File dataRoot = new File(HOME + "/stack/");
		new ParserLauncher(dataRoot);
		
		System.exit(0);
	}
}

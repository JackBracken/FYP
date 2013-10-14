package main.java.me.jackbracken.FYP;

import main.java.me.jackbracken.FYP.FileUtilities.ParseUserFile;
import main.java.me.jackbracken.FYP.Models.User;
import main.java.me.jackbracken.FYP.GUI.*;

import com.googlecode.flyway.core.Flyway;

public class FYP {
	public static void main(String[] args) {
		// Create flyway instance
		Flyway flyway = new Flyway();
		// Point to database
		flyway.setDataSource("jdbc:postgresql:fyp", "postgres", "october");
		flyway.migrate();
	
		new XMLImporter("FYP");
	}
}

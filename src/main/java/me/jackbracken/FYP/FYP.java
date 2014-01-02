package main.java.me.jackbracken.FYP;

import java.io.File;
import java.sql.SQLException;

import main.java.me.jackbracken.FYP.FileUtilities.ParserLauncher;
import main.java.me.jackbracken.FYP.Graph.Graph;
import main.java.me.jackbracken.FYP.Graph.Node;
import main.java.me.jackbracken.FYP.Models.User;

import com.googlecode.flyway.core.Flyway;

public class FYP {
	public static void main(String[] args) throws SQLException {
		// Create flyway instance
		Flyway flyway = new Flyway();
		// Point to database
		flyway.setDataSource("jdbc:postgresql:fyp", "karma", "karma");
		flyway.migrate();

		final String HOME = System.getenv("HOME");
		final File DATA_ROOT = new File(HOME + "/stack/");
		
		ParserLauncher pl = new ParserLauncher(DATA_ROOT);


		
		double heapSize = Runtime.getRuntime().totalMemory();
		double heapMaxSize = Runtime.getRuntime().maxMemory();
		System.out.println("Percentage of heap used: " + heapSize / heapMaxSize);
		
		System.exit(0);
	}
}

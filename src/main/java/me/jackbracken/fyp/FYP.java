package main.java.me.jackbracken.fyp;

import java.io.File;
import java.sql.SQLException;

import main.java.me.jackbracken.fyp.fileutilities.ParserLauncher;
import com.googlecode.flyway.core.Flyway;

public class FYP {
	public static void main(String[] args) throws SQLException {
		// Create flyway instance
		final long startTime = System.currentTimeMillis();
		
		Flyway flyway = new Flyway();
		
		// Point to database
		flyway.setDataSource("jdbc:postgresql:fyp", "karma", "karma");
		flyway.migrate();

		final String HOME = System.getProperty("user.home");
		final File DATA_ROOT = new File(HOME + "/stack");
		
		System.out.println("DATA_ROOT is: " + DATA_ROOT);
		
		new ParserLauncher(DATA_ROOT);
		
		final long endTime = System.currentTimeMillis();
		
		// Close-down stuff. Print run-time, heap used etc.
		double heapSize = Runtime.getRuntime().totalMemory();
		double heapMaxSize = Runtime.getRuntime().maxMemory();
		System.out.println("Percentage of heap used: " + heapSize / heapMaxSize);
		
		System.out.println("Total execution time: " + ((endTime - startTime) / 1000) + " seconds");
		
		System.exit(0);
	}
}

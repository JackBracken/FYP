package main.java.me.jackbracken.FYP;

import com.googlecode.flyway.core.Flyway;

public class FYP {
	public static void main(String[] args) {
		// Create flyway instance
		Flyway flyway = new Flyway();
//		
//		// Point to database
		flyway.setDataSource("jdbc:postgresql:FYP", "postgres", "october");
		flyway.migrate();
	}
}

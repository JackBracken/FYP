package main.java.me.jackbracken.FYP;

import java.sql.Connection;
import java.sql.DriverManager;

public class FYP {
	public static void main(String[] args) {
		Connection c = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FYP", "postgres", "october");
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(1);
		}
		
		System.out.println("Opened database succesfully.");
	}
}

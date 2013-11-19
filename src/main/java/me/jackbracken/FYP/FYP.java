package main.java.me.jackbracken.FYP;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.googlecode.flyway.core.Flyway;
import org.postgresql.ds.PGPoolingDataSource;

public class FYP {
	public static void main(String[] args) throws SQLException {
		// Create flyway instance
		Flyway flyway = new Flyway();
		// Point to database
		flyway.setDataSource("jdbc:postgresql:fyp", "karma", "karma");
		flyway.migrate();

		final String HOME = System.getenv("HOME");
		
		File voteFile = new File(HOME + "/stack/photo/Votes.xml");
		File dataRoot = new File(HOME + "/stack/");

//		DataSource ds = new JdbcConnectionPool("jdbc:postgresql:fyp", "karma", "karma");

		PGPoolingDataSource ds = new PGPoolingDataSource();
		ds.setDataSourceName("fyp");
		ds.setDatabaseName("fyp");
		ds.setUser("karma");
		ds.setPassword("karma");
		ds.setMaxConnections(3);
		
		DBI dbi = new DBI(ds);
		
		System.exit(0);
	}
}

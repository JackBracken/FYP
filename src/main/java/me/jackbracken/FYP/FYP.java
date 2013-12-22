package main.java.me.jackbracken.FYP;

import java.io.File;
import java.sql.SQLException;
import java.util.Vector;

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
		
//		File voteFile = new File(HOME + "/stack/photo/Votes.xml");
		Graph<User> g = new Graph<User>();
		
		File dataRoot = new File(HOME + "/stack/");
		ParserLauncher pl = new ParserLauncher(dataRoot);
		
		Vector<User> users = pl.getUserList();
//		System.out.println(users.toString());
		for(int i = 0; i < 1000000; i++) {
			short j = 123;
			g.addNode(new Node<User>(new User(i, j, "Name")));
		}
		
		System.out.println(g.getNumberOfNodes());
		
		double heapSize = Runtime.getRuntime().totalMemory();
		double heapMaxSize = Runtime.getRuntime().maxMemory();
		System.out.println("Percentage of heap used: " + heapSize / heapMaxSize);

//		DataSource ds = new JdbcConnectionPool("jdbc:postgresql:fyp", "karma", "karma");

//		PGPoolingDataSource ds = new PGPoolingDataSource();
//		ds.setDataSourceName("fyp");
//		ds.setDatabaseName("fyp");
//		ds.setUser("karma");
//		ds.setPassword("karma");
//		ds.setMaxConnections(3);
//		
//		DBI dbi = new DBI(ds);
		
		System.exit(0);
	}
}

package main.java.me.jackbracken.fyp;

import java.io.File;
import java.sql.SQLException;

import main.java.me.jackbracken.fyp.fileutilities.ParserLauncher;

import org.gephi.graph.api.DirectedGraph;
import org.gephi.graph.api.Edge;
import org.gephi.graph.api.GraphController;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.project.api.ProjectController;
import org.gephi.project.api.Workspace;
import org.openide.util.Lookup;

import com.googlecode.flyway.core.Flyway;

public class FYP {
	public static void main(String[] args) throws SQLException {
		// Create flyway instance
		Flyway flyway = new Flyway();
		
		// Point to database
		flyway.setDataSource("jdbc:postgresql:fyp", "karma", "karma");
		flyway.migrate();

		final String HOME = System.getenv("HOME");
		final File DATA_ROOT = new File(HOME + "/stack");
		
		new ParserLauncher(DATA_ROOT);
		
		// Close-down stuff. Print run-time, heap used etc.
		double heapSize = Runtime.getRuntime().totalMemory();
		double heapMaxSize = Runtime.getRuntime().maxMemory();
		System.out.println("Percentage of heap used: " + heapSize / heapMaxSize);
		
		System.exit(0);
	}
}

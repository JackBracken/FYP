package main.java.me.jackbracken.fyp.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import main.java.me.jackbracken.fyp.models.Post;
import main.java.me.jackbracken.fyp.models.User;

import org.gephi.graph.api.DirectedGraph;
import org.gephi.graph.api.GraphController;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.graph.api.Edge;
import org.gephi.project.api.ProjectController;
import org.gephi.project.api.Workspace;
import org.openide.util.Lookup;

public class GraphBuilder {
	
	private HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
	private HashMap<Integer, Edge> edges = new HashMap<Integer, Edge>();
	private Node n;
	private Edge e;
	private String id;
	
	public GraphBuilder(Vector<User> users, Vector<Post> posts) {
		
		// Init a gephi project
		ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
		pc.newProject();
		
		// Get a GraphModel from Workspace
		GraphModel gm = Lookup.getDefault().lookup(GraphController.class).getModel();
		
		// Create nodes from users
		for(User u: users) {
			id = String.valueOf(u.getUserId());
			n = gm.factory().newNode(id);
			n.getNodeData().setLabel(u.getName());
			nodes.put(u.getUserId(), n);
		}
		
		for(Post p: posts) {
			if(p.getPostTypeID() == 2) {
				e = gm.factory().newEdge(nodes.get(p.getOwnerID()), nodes.get(100), p.getScore(), true);
				edges.put(p.getID(), e);
			}
		}
		
		// Append to graph
		DirectedGraph diGraph = gm.getDirectedGraph();
		for(Node n: nodes.values()) {
			diGraph.addNode(n);
		}
		
		for(Edge e: edges.values()) {
			diGraph.addEdge(e);
		}
		
		System.out.println("Nodes: " + diGraph.getNodeCount() + " Edges: " + diGraph.getEdgeCount());
	}

}

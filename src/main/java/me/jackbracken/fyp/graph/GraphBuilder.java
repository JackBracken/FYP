package main.java.me.jackbracken.fyp.graph;

import java.util.HashMap;
import java.util.Vector;

import main.java.me.jackbracken.fyp.models.Answer;
import main.java.me.jackbracken.fyp.models.Question;
import main.java.me.jackbracken.fyp.models.User;

import org.gephi.graph.api.DirectedGraph;
import org.gephi.graph.api.Edge;
import org.gephi.graph.api.GraphController;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.project.api.ProjectController;
import org.openide.util.Lookup;

public class GraphBuilder {
	
	private HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
	private HashMap<Integer, Edge> edges = new HashMap<Integer, Edge>();
	private Node n;
	private Edge e;
	private String id;
	
	private Vector<User> users = new Vector<User>();
	private Vector<Answer> answers = new Vector<Answer>();
	private Vector<Question> questions = new Vector<Question>();
	
	public GraphBuilder(Vector<User> users, Vector<Answer> answers, Vector<Question> questions) {
		this.users = users;
		this.answers = answers;
		this.questions = questions;
		
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
		
		for(Answer a: answers) {
			System.out.println("parent id " + a.getParentID() + " : size of vector? " + questions.size());	
			e = gm.factory().newEdge(
						nodes.get(questions.get(a.getParentID()).getOwnerID()),
						nodes.get(a.getOwnerID()),
						a.getScore(),
						true
					);
			
			edges.put(a.getID(), e);
		
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
		System.out.println(answers.size());
	}

}

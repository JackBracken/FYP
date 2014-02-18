package main.java.me.jackbracken.fyp.graph;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import main.java.me.jackbracken.fyp.models.Answer;
import main.java.me.jackbracken.fyp.models.Question;
import main.java.me.jackbracken.fyp.models.User;

import org.apache.batik.ext.awt.geom.Cubic;
import org.gephi.graph.api.DirectedGraph;
import org.gephi.graph.api.Edge;
import org.gephi.graph.api.GraphController;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.io.exporter.api.ExportController;
import org.gephi.preview.api.PreviewController;
import org.gephi.preview.api.PreviewModel;
import org.gephi.preview.api.PreviewProperty;
import org.gephi.project.api.ProjectController;
import org.openide.util.Lookup;

public class GraphBuilder {
	
	private HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
	private HashMap<Integer, Edge> edges = new HashMap<Integer, Edge>();
	private Node n;
	private Edge e;
	private String id;
	
//	private LinkedList<User> users = new LinkedList<User>();
//	private HashMap<Integer, Answer> answers = new HashMap<Integer, Answer>();
//	private HashMap<Integer, Question> questions = new HashMap<Integer, Question>();
	
	public GraphBuilder(LinkedList<User> users, HashMap<Integer, Answer> answers, HashMap<Integer, Question> questions) {
//		this.users = users;
//		this.answers = answers;
//		this.questions = questions;
		
		// Init a gephi project
		ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
		pc.newProject();
		
		// Get a GraphModel from Workspace
		GraphModel gm = Lookup.getDefault().lookup(GraphController.class).getModel();
		
		System.out.println("Beginning graph builder");
		
		long startTime = System.currentTimeMillis();
		
		// Create nodes from users
		for(User u: users) {
			id = String.valueOf(u.getUserId());
			n = gm.factory().newNode(id);
			n.getNodeData().setLabel(u.getName());
			nodes.put(u.getUserId(), n);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time to create nodes: " + ((endTime - startTime) / 1000) + " seconds");
		
		startTime = System.currentTimeMillis();
		
		for(Answer a: answers.values()) {
//			System.out.println("parent id " + a.getParentID() + " : size of vector? " + questions.size());	
			e = gm.factory().newEdge(
						nodes.get(questions.get(a.getParentID()).getOwnerID()),
						nodes.get(a.getOwnerID()),
						a.getScore(),
						true
					);
			
//			System.out.println("Creating edge" + e.toString());
			
			edges.put(a.getID(), e);
		
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("Time to create edges: " + ((endTime - startTime) / 1000) + " seconds"); 
		
		startTime = System.currentTimeMillis();
		
		// Append to graph
		DirectedGraph diGraph = gm.getDirectedGraph();
		for(Node n: nodes.values()) {
			diGraph.addNode(n);
		}
		
		for(Edge e: edges.values()) {
			diGraph.addEdge(e);
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("Time to append to graph: " + ((endTime - startTime) / 1000) + " seconds");

		System.out.println("Nodes: " + diGraph.getNodeCount() + " Edges: " + diGraph.getEdgeCount());
		System.out.println(answers.size());
		
		PreviewController previewController = Lookup.getDefault().lookup(PreviewController.class);
		PreviewModel previewModel = previewController.getModel();
		previewModel.getProperties().putValue(PreviewProperty.SHOW_NODE_LABELS, Boolean.TRUE);
		
		ExportController ec = Lookup.getDefault().lookup(ExportController.class);
		try {
			ec.exportFile(new File(users.get(0).getSite() + ".gexf"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}

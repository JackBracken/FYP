package main.java.me.jackbracken.fyp.graph;

import java.util.Vector;

public class Graph<T> {
	protected Vector<Node<T>> nodes = new Vector<Node<T>>();
	protected Vector<Edge<T>> edges = new Vector<Edge<T>>();

	public double[][] getAdjacencyMatrix() {
		double[][] adjacencyMatrix = new double[nodes.size()][nodes.size()];

		for (int i = 0; i < nodes.size(); i++) {
			for (int j = 0; j < nodes.size(); j++) {
				if (i == j)
					adjacencyMatrix[i][j] = 0;
				else
					adjacencyMatrix[i][j] = Double.POSITIVE_INFINITY;
			}
		}

		for (int i = 0; i < nodes.size(); i++) {
			Node<T> node = nodes.elementAt(i);

			for (int j = 0; j < edges.size(); j++) {
				Edge<T> edge = edges.elementAt(j);

				if (edge.question == node) {
					int indexOfNeighbour = nodes.indexOf(edge.answer);
					adjacencyMatrix[i][indexOfNeighbour] = edge.weight;
				}
			}
		}

		return adjacencyMatrix;
	}

	public int indexOf(Node<T> n) {
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.elementAt(i).data.equals(n.data))
				return i;
		}

		return -1;
	}

	public Vector<Node<T>> getNodes() {
		return nodes;
	}

	public Vector<Edge<T>> getEdges() {
		return edges;
	}

	public Node<T> getNodeAtIndex(int i) {
		return nodes.elementAt(i);
	}

	public void unvisitAllNodes() {
		for (int i = 0; i < nodes.size(); i++) {
			nodes.elementAt(i).unvisit();
		}
	}

	public Vector<Node<T>> getNeighbors(Node<T> a) {
		Vector<Node<T>> neighbors = new Vector<Node<T>>();

		for (int i = 0; i < edges.size(); i++) {
			Edge<T> edge = edges.elementAt(i);

			if (edge.question == a) {	
				neighbors.add(edge.answer);
			}
		}

		return neighbors;
	}

	public Graph() {

	}

	public void addNode(Node<T> n) {
		nodes.add(n);
	}

	public void removeNode(Node<T> n) {

	}

	public void addEdge(Edge<T> e) {
		edges.add(e);
	}

	public void removeEdge(Edge<T> e) {

	}
	
	public void printNodes() {
		System.out.println(nodes);
	}
	
	public void printEdges() {
		System.out.println(edges);
	}
	
	public int getNumberOfNodes() {
		return nodes.size();
	}
	
	public int getNumberOfEdges() {
		return edges.size();
	}

}

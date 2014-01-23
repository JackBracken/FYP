package main.java.me.jackbracken.fyp.graph;

public class Node<T> {
	protected T data;
//	protected State state;
	protected boolean visited;
	
	public Node(T data) {
		this.data = data;
//		this.state = State.Unvisited;
		visited = false;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void visit() {
		visited = true;
	}
	
	public void unvisit() {
		visited = false;
	}
	
	public String toString() {
		return data.toString();
	}
}

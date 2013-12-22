package main.java.me.jackbracken.FYP.Graph;

public class Node<T> {
	protected T data;
	protected State state;

	public Node(T data) {
		this.data = data;
		this.state = State.Unvisited;
	}
}

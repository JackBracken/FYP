package main.java.me.jackbracken.FYP.Graph;

public class Edge<T> {
	Node<T> question, answer;
	short weight;
	
	public Edge(Node<T> question, Node<T> answer, short weight) {
		this.question = question;
		this.answer = answer;
		this.weight = weight;
	}
	
	public short getWeight() {
		return weight;
	}
	
	public String toString() {
		return question + " --> " + answer;
	}
	
}
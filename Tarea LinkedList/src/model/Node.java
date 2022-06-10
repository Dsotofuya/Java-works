package model;

public class Node {
	
	private Profile profile;
	private Node next;
	
	public Node(Profile profile) {
		this.profile = profile;
	}
	
	public Node(Profile profile, Node next) {
		this.profile = profile;
		this.next = next;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Profile getData() {
		return profile;
	}
}
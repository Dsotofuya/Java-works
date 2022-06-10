package model;

import java.util.ArrayList;

public class Node {

	private String data;
	private ArrayList<Node> children;

	public Node(String data) {
		this.data = data;
		children = new ArrayList<>();
	}

	public void addChild(Node child) {
		children.add(child);
	}

	public void removeChild(Node child) {
		children.remove(child);
	}

	@Override
	public String toString() {
		return data;
	}

	public ArrayList<Node> getChildren() {
		return new ArrayList<>(children);
	}

	public String getData() {
		return data;
	}
}
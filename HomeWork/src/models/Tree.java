package models;

import java.util.ArrayList;

public class Tree {

	private Node root;

	public Tree() {
		root = new Node(new Level(), "1");
	}

	public Node getRoot() {
		return root;
	}

	public void print() {
		print(root, "");
	}

	private void print(Node node, String level) {
		level += "  ";
		System.out.println(level + node);
		for (Node actual : node.getChildren()) {
			print(actual, level);
		}
	}

	public Node search(String id) {
		if (root.getId().equals(id)) {
			return root;
		}
		return search(root, id);
	}

	private Node search(Node node, String id) {
		if (!node.getChildren().isEmpty()) {
			for (Node actual : node.getChildren()) {
				if (actual.getId().equals(id)) {
					return actual;
				} else {
					Node search = search(actual, id);
					if (search != null) {
						return search;
					}
				}
			}
		}
		return null;
	}

	public Node searchDad(Node node) {
		for (int i = 0; i < root.getChildren().size(); i++) {
			if (root.searchChild(node)) {
				return root;
			}
		}
		return searchDad(root, node);
	}

	private Node searchDad(Node node, Node nodeChild) {
		if (!node.getChildren().isEmpty()) {
			for (Node actual : node.getChildren()) {
				if (actual.searchChild(nodeChild)) {
					return actual;
				} else {
					Node search = searchDad(actual, nodeChild);
					if (search != null) {
						return search;
					}
				}
			}
		}
		return null;

	}

	public ArrayList<Node> path(Node node) {
		ArrayList<Node> path = new ArrayList<Node>();
		while (node != root) {
			node = searchDad(node);
			path.add(node);
		}
		
		return path;
	}

}
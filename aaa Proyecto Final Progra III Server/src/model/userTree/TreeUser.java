package model.userTree;

import java.util.ArrayList;

public class TreeUser {

	private ANode root;

	public TreeUser() {
		root = new NodeRoot("Users");
	}

	public void addUser(String name, String password) {
		root.add(name, password);
	}

	public ANode search(String name) {
		if (root.getName().equalsIgnoreCase(name)) {
			return root;
		}
		return search(root, name);
	}

	private ANode search(ANode node, String name) {
		if (!node.getChildren().isEmpty()) {
			for (ANode actual : node.getChildren()) {
				if (actual.getName().equalsIgnoreCase(name)) {
					return actual;
				} else {
					ANode search = search(actual, name);
					if (search != null) {
						return search;
					}
				}
			}
		}
		return null;
	}

	public ANode searchDad(ANode node) {
		for (int i = 0; i < root.getChildren().size(); i++) {
			if (root.search(node.getName())) {
				return root;
			}
		}
		return searchDad(root, node);
	}

	private ANode searchDad(ANode node, ANode nodeChild) {
		if (!node.getChildren().isEmpty()) {
			for (ANode actual : node.getChildren()) {
				if (actual.search(nodeChild.getData())) {
					return actual;
				} else {
					ANode search = searchDad(actual, nodeChild);
					if (search != null) {
						return search;
					}
				}
			}
		}
		return null;
	}

	public void delete(String name) {
		for (ANode node : root.getChildren()) {
			for (ANode nodeChild : node.getChildren()) {
				if (nodeChild.getData().equalsIgnoreCase(name)) {
					node.removeChild(nodeChild);
				}
				if (node.getChildren().size() == 0) {
					root.removeChild(node);
				}
			}
		}
	}

	public ArrayList<ANode> path(ANode node) {
		ArrayList<ANode> path = new ArrayList<ANode>();
		while (node != root) {
			node = searchDad(node);
			path.add(node);
		}
		return path;
	}

	public ANode getRoot() {
		return root;
	}
}
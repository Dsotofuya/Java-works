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
	
	public void addArchive(ANode user, String folder, String archive) {
		for (ANode folderNode : user.getChildren()) {
			if (folderNode.getName().equalsIgnoreCase(folder)) {
				folderNode.add(archive, null);
			}
		}
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
	
	public void setRoot(ANode root) {
		this.root = root;
	}

	public ArrayList<String> listUsers() {
		return listUsers(root, new ArrayList<String>(), Type.USER);
	}
	
	private ArrayList<String> listUsers(ANode node, ArrayList<String> list, Type type) {
		for (ANode actual : node.getChildren()) {
			if (actual.getType().equals(type)) {
				list.add(actual.getName());
			}
			listUsers(actual, list, type);
		}
		return list;
	}
}
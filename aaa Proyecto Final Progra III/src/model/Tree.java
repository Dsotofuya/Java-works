package model;

import java.util.ArrayList;


public class Tree {

	private static final String FOLDERS = "Folders";

	private NodeFolder root;

	public Tree() {
		root = new NodeFolder(FOLDERS, State.VIEW, Type.FOLDER);
	}

	public INode search(String name) {
		if (root.getName().equalsIgnoreCase(name)) {
			return root;
		}
		return search(root, name);
	}

	private INode search(INode node, String name) {
		if (!node.getChildren().isEmpty()) {
			for (INode actual : node.getChildren()) {
				if (actual.getName().equalsIgnoreCase(name)) {
					return actual;
				} else {
					INode search = search(actual, name);
					if (search != null) {
						return search;
					}
				}
			}
		}
		return null;
	}

	public INode searchDad(INode node) {
		for (int i = 0; i < root.getChildren().size(); i++) {
			if (root.search(node.getData())) {
				return root;
			}
		}
		return searchDad(root, node);
	}

	private INode searchDad(INode node, INode nodeChild) {
		if (!node.getChildren().isEmpty()) {
			for (INode actual : node.getChildren()) {
				if (actual.search(nodeChild.getData())) {
					return actual;
				} else {
					INode search = searchDad(actual, nodeChild);
					if (search != null) {
						return search;
					}
				}
			}
		}
		return null;
	}

	public void addNewFolder(String name, State state) {
		root.add(name, null, state, Type.FOLDER);
	}

	public void addNewFolderInsideOtherFolder(String folder, String name, State state) {
		search(folder).add(name, null, state, Type.FOLDER);
	}
	
	public void addNewPostal(String folder, String name, State state) {
		search(folder).add(name, null, state, Type.POSTAL);
	}

	public void addNewLeaf(String postal, String name, String data, Type type, State state) {
		search(postal).add(name, data, state, type);
	}

	public void delete(String name) {
		for (INode node : root.getChildren()) {
			for (INode nodeChild : node.getChildren()) {
				if (nodeChild.getData().equalsIgnoreCase(name)) {
					node.removeChild(nodeChild);
				}
				if (node.getChildren().size() == 0) {
					root.removeChild(node);
				}
			}
		}
	}

	public ArrayList<INode> path(INode node) {
		ArrayList<INode> path = new ArrayList<INode>();
		while (node != root) {
			node = searchDad(node);
			path.add(node);
		}
		return path;
	}

	public void print() {
		print(root, "");
	}

	private void print(INode node, String level) {
		level += "  ";
		System.out.println(level + node.getName() + "-"+ node.getState());
		for (INode actual : node.getChildren()) {
			print(actual, level);
		}
	}
	

	public ArrayList<String> listObjects(Type type) {
		return listObjects(root, new ArrayList<String>(), type);
	}
	
	private ArrayList<String> listObjects(INode node, ArrayList<String> list, Type type) {
		for (INode actual : node.getChildren()) {
			if (actual.getType().equals(type)) {
				list.add(actual.getName());
			}
			listObjects(actual, list, type);
		}
		return list;
	}

	public ArrayList<String> listAll() {
		return listAll(root, new ArrayList<String>());
	}
	
	private ArrayList<String> listAll(INode node, ArrayList<String> list){
		for (INode actual : node.getChildren()) {
				list.add(actual.getName());
				listAll(actual, list);
		}
		return list;
	}

	public ArrayList<String> listEspesific(String name, Type type) {
		return listEspesific(search(name), new ArrayList<String>(), type);
	}
	
	private ArrayList<String> listEspesific(INode node, ArrayList<String> list, Type type) {
		for (INode actual : node.getChildren()) {
			if (actual.getType().equals(type)) {
				list.add(actual.getName());
			}
			listObjects(actual, list, type);
		}
		return list;
	}
	
	public INode getRoot() {
		return root;
	}

	public void setRoot(NodeFolder root) {
		this.root = root;
	}
}
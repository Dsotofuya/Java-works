package models;

import java.util.ArrayList;

public class Tree {
	private INode root;

	public Tree() {
		root = new Node("Operadores");
	}

	public INode getRoot() {
		return root;
	}

	public void addEmpresa(String id) {
		root.addChild(new NodeEmpresa(id));
	}

	public void addZona(String id, String empresa) {
		search(empresa).addChild(new NodeZona(id));
	}

	public void addUser(String id, String zona) {
		search(zona).addChild(new NodeUser(id));
	}

	public void print() {
		print(root, "");
	}

	private void print(INode node, String level) {
		level += "  ";
		System.out.println(level + node);
		for (INode actual : node.getChildren()) {
			print(actual, level);
		}
	}

	public INode search(String id) {
		if (root.getId().equals(id)) {
			return root;
		}
		return search(root, id);
	}

	private INode search(INode node, String id) {
		if (!node.getChildren().isEmpty()) {
			for (INode actual : node.getChildren()) {
				if (actual.getId().equals(id)) {
					return actual;
				} else {
					INode search = search(actual, id);
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
			if (root.searchChild(node)) {
				return root;
			}
		}
		return searchDad(root, node);
	}

	public void orgZona() {
		orgZona(root.getChildren());
	}

	private void orgZona(ArrayList<INode> operadores) {
		for (INode iNode : operadores) {
			for (INode iNode2 : iNode.getChildren()) {
				if (iNode2.getChildren().size() > 3) {
					NodeZona zona = new NodeZona("zona");
					for (int i = 3; i < iNode2.getChildren().size(); i++) {
						zona.addChild(new NodeUser(iNode2.getChildren().get(i).getId()));
						iNode2.removeChild(search(iNode2.getChildren().get(i).getId()));
					}
					iNode.addChild(zona);

				}else {
					continue;
				}
			}
			for (INode iNodeAux : iNode.getChildren()) {
				if (iNodeAux.getChildren().size() > 3) {
					orgZona(operadores);
				}
			}
		}
	}

	private INode searchDad(INode node, INode nodeChild) {
		if (!node.getChildren().isEmpty()) {
			for (INode actual : node.getChildren()) {
				if (actual.searchChild(nodeChild)) {
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

	public ArrayList<INode> path(INode node) {
		ArrayList<INode> path = new ArrayList<INode>();
		while (node != root) {
			node = searchDad(node);
			path.add(node);
		}
		return path;
	}

	public void remove(INode node) {
		searchDad(node).removeChild(node);
	}

}

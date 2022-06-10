package models;

import java.util.ArrayList;

public class Node {

	private ArrayList<Node> children;
	private Level level;
	private String id;

	public Node(Level level, String id) {
		this.id = id;
		this.level = level;
		this.children = new ArrayList<>();
	}

	public void addChild(Node child) {
		children.add(child);
	}

	public void addChilds(ArrayList<Node> childs) {
		children.addAll(childs);
	}

	public void removeChild(Node child) {
		children.remove(child);
	}

	public ArrayList<Node> getChildren() {
		return new ArrayList<>(children);
	}

	public boolean searchChild(Node nodeChild) {
		for (Node node : children) {
			if (node.id.equals(nodeChild.getId())) {
				return true;
			}
		}
		return false;
	}

	public void clear() {
		children.clear();
	}

	public Level getLevel() {
		return level;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}

}
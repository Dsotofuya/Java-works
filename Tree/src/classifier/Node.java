package classifier;

import java.util.ArrayList;

public class Node {

	private ArrayList<Node> children;
	private String label;
	
	public Node(String label) {
		this.label = label;
		children = new ArrayList<>();
	}
	
	public void addChild(Node child) {
		children.add(child);
	}
	
	
	public ArrayList<Node> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return label;
	}
}
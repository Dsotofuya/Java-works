package network;

import java.util.ArrayList;

public class Node{

	private ArrayList<Node> children;
	private double weigth;
	private String value;
	private ICalculate iCalculate;
	
	public Node(double weigth, ICalculate iCalculate) {
		this.iCalculate = iCalculate; 
		this.weigth = weigth;
		children = new ArrayList<>();
	}
	
	public void addChild(Node child) {
		children.add(child);
	}
	
	public ArrayList<Node> getChildren() {
		return children;
	}

	public double getWeigth() {
		return weigth;
	}

	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}

	public String getValue() {
		return iCalculate.getResponse();
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}
}
package models;

import java.util.ArrayList;

public class Node <T>{

	private T info;
	private ArrayList<Node<T>> childs;
	
	public Node(T info) {
		this.info = info;
		childs = new ArrayList<>();
	}
	
	public void addChild(Node<T> child) {
		childs.add(child);
	}

	public T getInfo() {
		return info;
	}

	public ArrayList<Node<T>> getChilds() {
		return childs;
	}
	
	@Override
	public String toString() {
		return info.toString();
	}

	public void removeChild(T infoDelete) {
		childs.removeIf(node -> (node.getInfo().equals(infoDelete)));
	}
}
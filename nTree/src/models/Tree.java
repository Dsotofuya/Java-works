package models;

import java.util.ArrayList;

public class Tree <T>{

	private Node<T> root;

	public Tree(T info) {
		root = new Node<T>(info);
	}

	public Node<T> getRoot() {
		return root;
	}

	public Node<T> search(T info) throws Exception {
		ArrayList<Node<T>> list = new ArrayList<>();
		search(list,root, info);
		if(list.isEmpty()) {
			throw new Exception("Not found");
		}
		return list.get(0);
	}

	private void search(ArrayList <Node<T>> list, Node<T> actual,T info){
		if(actual.getInfo().equals(info)) {
			list.add(actual);			
		}
		for (Node<T> child : actual.getChilds()) {
			search(list, child, info);
		}
	}
	
	public void delete(T info) {
		Node<T> dad = findDad(info);
		dad.removeChild(info);
	}
	
	public Node<T> findDad(T info){
		return findDad(root, info);
	}
	
	private Node<T> findDad(Node<T> actual, T info){
		if(actual.getChilds().stream().filter(node -> info.equals(node.getInfo()))
				  .findAny().orElse(null) != null) {
			return actual;
		}else {
			for (Node<T> child : actual.getChilds()) {
				findDad(child, info);
			}
		}
		return null;
	}
}
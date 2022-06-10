package model;

public class ProfileList {
	
	private Node first;

	public void addNode(Node node) {
		if (first != null) {
			Node actual = first;
			while (actual.getNext() != null) {
				actual = actual.getNext();
			}
			actual.setNext(node);
		} else {
			first = node;
		}
	}

	public void addNodeToHead(Node node) {
		if (first != null) {
			node.setNext(first);
		}
		first = node;
	}

	public void addNodeNextTo(Node actual, Node node) {
		Node next = actual.getNext();
		actual.setNext(node);
		node.setNext(next);
	}

	public void deleteHead() {
		if (first != null) {
			Node auxNext = first.getNext();
			first = first.getNext();
			first.setNext(auxNext.getNext());
		}
	}

	public void delete(int id) {
		Node before = null;
		Node actual = first;
		while (actual.getData().getId() != id) {
			before = actual;
			actual = actual.getNext();
		}
		Node aux = actual.getNext();
		before.setNext(aux);
		actual = null;
	}

	public void deleteLast() {
		Node before = null;
		Node actual = first;
		while (actual.getNext() != null) {
			before = actual;
			actual = actual.getNext();
		}
		before.setNext(null);
		actual = null;
	}
	
	public Node get(int id) {
		Node actual = first;
		while (actual.getData().getId() != id) {
			actual = actual.getNext();
		}
		return actual;
	}
	
	public void print() {
		Node actual = first;
		while (actual != null) {
			System.out.println(actual.getData().getId());
			actual = actual.getNext();
		}
	}
	
	public void printDirection() {
		Node actual = first;
		while (actual != null) {
			if (actual.getNext() != null) {
				System.out.println(actual.getNext().getData().getId());
			} else {
				System.out.println("null");
			}
			actual = actual.getNext();
		}
	}

	public Node getFirst() {
		return first;
	}
}


package model.queue;

public class ImageQueue {
	
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

	public void deleteHead() {
		if (first != null) {
			Node auxNext = first.getNext();
			first = first.getNext();
			if (auxNext != null) {
				first.setNext(auxNext.getNext());
			}
		}
	}
	
	public void printDirection() {
		Node actual = first;
		while (actual != null) {
			if (actual.getNext() != null) {
				System.out.println(actual.getNext().getImage());
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


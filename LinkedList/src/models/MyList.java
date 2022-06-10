package models;

public class MyList {

	private Node first;

	public void addNode(Node node) {
		if (first != null) {
			// Me ubico en el primer nodo
			Node actual = first;
			// Voy hasta el ultimo nodo
			while (actual.getNext() != null) {
				actual = actual.getNext();
			}
			// ubico el nuevo nodo despues del ultimo
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

	public void print() {
		Node actual = first;
		while (actual != null) {
			System.out.println(actual.getData());
			actual = actual.getNext();
		}
	}

	public void printDirection() {
		Node actual = first;
		while (actual != null) {
			if (actual.getNext() != null) {
				System.out.println(actual.getNext().getData());
			} else {
				System.out.println("null");
			}
			actual = actual.getNext();
		}
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

	public void delete(String date) {
		Node before = null;
		Node actual = first;
		while (actual.getData() != date) {
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

	public Node getFirst() {
		return first;
	}

	public static void main(String[] args) {
		MyList list = new MyList();
		list.addNode(new Node("A"));
		list.addNode(new Node("B"));
		list.addNode(new Node("C"));
		list.addNodeToHead(new Node("D"));
		list.addNodeToHead(new Node("E"));
		list.addNode(new Node("Z"));
		list.print();
		System.out.println("--------------------");
		list.delete("D");
		list.print();
		System.out.println("--------------------");
		list.delete("A");
		list.print();
		list.deleteHead();
		System.out.println("Syso: Cabeza Borrada");
		list.print();
		System.out.println("Syso: Direcciones");
		list.printDirection();
		System.out.println("---------------------------");
		list.deleteLast();
		list.deleteLast();
		list.print();
	}
}

package model;

public class MyStack {

	private MyNode head;

	public void push(MyNode newNode) {
		if (head == null) {
			head = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
	}

	public int pop() throws Exception {
		if (head == null) {
			throw new Exception("Stack is empty!");
		}
		MyNode first = head;
		head = first.getNext();
		int segs = first.getSegs();
		first = null;
		return segs;
	}

	public int peek() throws Exception {
		if (head == null || head.getNext() == null) {
			throw new Exception("Stack is empty or only have one element!");
		}
		return head.getNext().getSegs();
	}

	public void print() {
		MyNode actual = head;
		while (actual != null) {
			System.out.println("Recess: " + actual.getSegs());
			actual = actual.getNext();
		}
	}

	public MyNode getHead() {
		return head;
	}
}
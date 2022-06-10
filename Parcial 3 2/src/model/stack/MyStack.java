package model.stack;

import java.awt.image.BufferedImage;

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

	public BufferedImage pop() throws Exception {
		if (head == null) {
			throw new Exception("Stack is empty!");
		}
		MyNode first = head;
		head = first.getNext();
		BufferedImage image = first.getImage();
		first = null;
		return image;
	}
	
	public BufferedImage peek() throws Exception {
		if (head == null) {
			throw new Exception("Stack is empty!");
		}
		return head.getImage();
	}

	public MyNode getHead() {
		return head;
	}
}
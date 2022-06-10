package models;

public class Node {

	private Node left;
	private Node right;
	private int data;
	private int finded;
	private int fB;

	public Node(int data) {
		this.data = data;
		finded = 0;
		fB = 0;
	}

	public Node(Node left, Node right, int data) {
		this.left = left;
		this.right = right;
		this.data = data;
		finded = 0;
		fB = 0;
	}

	public void setfB(int fB) {
		this.fB = fB;
	}
	
	public int getfB() {
		return fB;
	}
	
	public int getFinded() {
		return finded;
	}

	public void setFinded(int finded) {
		this.finded = finded;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public boolean isFull() {
		return left != null && right != null;
	}

	@Override
	public String toString() {
		return String.valueOf(data + "- " + finded+ "- " + fB);
	}
}
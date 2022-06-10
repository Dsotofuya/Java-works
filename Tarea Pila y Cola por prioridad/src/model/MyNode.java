package model;

public class MyNode {

	private int segs;
	private MyNode next;
	
	public MyNode(int segs, MyNode next) {
		this.segs = segs;
		this.next = next;
	}

	public int getSegs() {
		return segs;
	}

	public MyNode getNext() {
		return next;
	}

	public void setNext(MyNode next) {
		this.next = next;
	}
}
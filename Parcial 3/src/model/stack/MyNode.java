package model.stack;

import java.awt.image.BufferedImage;

public class MyNode {

	private BufferedImage image;
	private MyNode next;
	
	public MyNode(BufferedImage image, MyNode next) {
		this.image = image;
		this.next = next;
	}

	public BufferedImage getImage() {
		return image;
	}

	public MyNode getNext() {
		return next;
	}

	public void setNext(MyNode next) {
		this.next = next;
	}
}
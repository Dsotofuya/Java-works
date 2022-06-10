package model.stack;

import java.awt.image.BufferedImage;

public class StackService {

	private MyStack history;
	
	public StackService() {
		history = new MyStack();
	}
	
	public void add(BufferedImage segs) {
		history.push(new MyNode(segs, null));
	}
	
	public BufferedImage pop() throws Exception {
		return history.pop();
	}
	
	public BufferedImage peek() throws Exception {
		return history.peek();
	}
}
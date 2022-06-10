package model.stack;

import java.awt.image.BufferedImage;

public class RecessService {

	private MyStack history;
	
	public RecessService() {
		history = new MyStack();
	}
	
	public void add(BufferedImage segs) {
		history.push(new MyNode(segs, null));
	}
	
	public BufferedImage getLastEvent() throws Exception {
		return history.pop();
	}
}
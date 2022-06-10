package model;

public class RecessService {

	private MyStack history;
	
	public RecessService() {
		history = new MyStack();
	}
	
	public void add(int segs) {
		history.push(new MyNode(segs, null));
	}
	
	public int getLastEvent() throws Exception {
		return history.pop();
	}
	
	public int getPenultimateEvent() throws Exception {
		return history.peek();
	}
	
	public void printRecess() {
		history.print();
	}
}
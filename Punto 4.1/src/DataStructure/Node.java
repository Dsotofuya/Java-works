package DataStructure;


public class Node <T>{
	private T data;
	private Node<T> next = null;
	private long priority;
	
	public Node(T data) {
		this.data = data;
	}
	
	public Node(T data , long priority) {
		this.data = data;
		this.priority = priority;
		
	}
	

	public Node() {
		
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public long getPriority() {
		return priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}
	
	
	
	
	

}

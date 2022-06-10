package doubleSimpleList;

public class Node<T> {
	
	protected T info;
	protected Node<T> next;
	protected Node<T> previus;
	
	public Node(T info) {
		this.info = info;
		this.next = null;
		this.previus = null;		
	}
	
	public Node(T info, Node<T> next, Node<T> previus) {
		this.info = info;
		this.next = next;
		this.previus = previus;
	}

	public T getInfo() {
		return info;
	}

	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}

	public void setPrevius(Node<T> previus) {
		this.previus = previus;
	}

	public Node<T> getPrevius() {
		return previus;
	}
}
package DataStructure;


public class MyDoubleNode <T>{

	private T element;
	private MyDoubleNode<T> previous;
	private MyDoubleNode<T> next;
	
	public MyDoubleNode()	{
		this.previous = null;
		this.next = null;
	}
	
	public MyDoubleNode(T element)	{
		this.previous = null;
		this.next = null;
		this.element = element;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public MyDoubleNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(MyDoubleNode<T> previous) {
		this.previous = previous;
	}

	public MyDoubleNode<T> getNext() {
		return next;
	}

	public void setNext(MyDoubleNode<T> next) {
		this.next = next;
	}
}

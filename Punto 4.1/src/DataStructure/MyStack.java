package DataStructure;

public class MyStack <T>{
	private Node<T> head;
	
	public MyStack() {
		this.head = null;
		}
	
	public void push(T data){
		if(this.head != null){
			this.head = new Node<T>(data);
		}
	}
	
	public T pop() {
		T element = null;
		Node<T> previusNode = new Node<>();
		if (head != null) {
			Node<T> currentNode = head;
			while (currentNode.getNext() != null) {
				previusNode = currentNode;
				currentNode = currentNode.getNext();
			}
			element = currentNode.getData();
			previusNode.setNext(null);
		}
		return element;
	}

	
	public T peek(){
		T element = null;
		if (head != null) {
			Node<T> currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			element = currentNode.getData();
		}
		return element;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public static void main(String[] args) {
		MyStack<Integer> myStack = new MyStack<>();
		myStack.push(45);
		myStack.push(56);
		myStack.push(213);
		myStack.push(987654);
		
		while(!myStack.isEmpty()) {
			System.out.println(myStack.pop());
		}
	}
}




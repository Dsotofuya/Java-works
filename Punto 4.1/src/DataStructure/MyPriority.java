package DataStructure;


public class MyPriority <T>{
	private long size;
	private Node<T> head;
	
	public MyPriority() {
		this.size = 0;
		this.head = null;
	}
	
	public void enqueue(T element, long priority) {
		int cont = 0;
		if (this.isEmpty()) {
			push(element, priority);
			
		} else {
			
			for (long i = 0; i < this.size; i++) {
				System.out.println(this.size);
				if (priority < nodeAt(i).getPriority()) { // checking priorities
					cont = (int) i;
				}
			}
			addAt(cont, element, priority);
		}
	}

	public T dequeue() {
		T element = null;
		if (head != null) {
			element = head.getData();
			head = head.getNext();
		}
		if (this.size > 0)
			this.size--;
		System.out.println("dequeue " + element);
		return element;
	}

	public void printCollection() {
		Node<T> actual = head;
		System.out.print("[ ");
		while (actual != null) {
			System.out.print( "(" + actual.getData() + "," + actual.getPriority() + ") ");
			actual = actual.getNext();
		}
		System.out.println("]");
	}

	public T front() {
		T element = null;
		if (head != null)
			element = head.getData();
		return element;
	}

	public long size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	private void push(T element, long priority) {
		Node<T> node = new Node<T>(element, priority);
		if (head == null) {
			head = node;
		} else {
			Node<T> currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
		}
		this.size++;
	}

	public Node<T> nodeAt(long index) {
		Node<T> currentNode = head;
		long count = 0;
		while (count < index) {
			count++;
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}
	
	public boolean addAt(long index, T element, long priority) {
		Node<T> node = new Node<T>(element, priority);
		boolean flag = true;
		Node<T> currentNode = head;
		Node<T> previousNode = null;
		long currentIndex = 0;

		if (index > this.size) {
			flag = false;
		

		if (index == 0) {
			node.setNext(currentNode);
			head = node;
		} else {
			while (currentIndex < index) {
				currentIndex++;
				previousNode = currentNode;
				currentNode.setNext(currentNode.getNext());
			}
			node.setNext(currentNode.getNext());
			previousNode.setNext(node);
		}
		this.size++;
	  }
		return flag;
	}

}

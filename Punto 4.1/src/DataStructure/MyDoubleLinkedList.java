package DataStructure;


public class MyDoubleLinkedList <T>{

	private long length;
	private MyDoubleNode<T> head;

	
	public MyDoubleLinkedList() {
		this.length = 0;
		this.head = null;
	}

	public long size() {
		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public void add(T element) {
		MyDoubleNode<T> node = new MyDoubleNode<T>(element);
		if (head == null) {
			head = node;
		} else {
			MyDoubleNode<T> currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
			node.setPrevious(currentNode);
		}
		length++;
	}
	/**
	 * Este metodo elimina un nodo si corresponde al dato que ingresa por parametro
	 * @param element
	 */
	@SuppressWarnings("null")
	public void remove(T element) {
		MyDoubleNode<T> currentNode = null;
		if (head != null) {
			 currentNode = head;
			 do{
				if(head.getElement() == element){
					this.head = head.getNext();
					this.length --;
				}else if(currentNode == null && currentNode.getElement() == element){
					currentNode.getPrevious().setNext(null);
				}else if (currentNode.getElement() == element) {
					currentNode.getPrevious().setNext(currentNode.getNext());
					currentNode.setPrevious(currentNode.getPrevious());
					this.length --;
				}
				currentNode = currentNode.getNext();
			}while (currentNode != null);
			
		}

	}
	/**
	 * Este metodo retorna el dato del nodo segun una posicion
	 * @param index
	 * @return
	 */
	public T elementAt(long index) {
		MyDoubleNode<T> currentNode = head;
		long count = 0;
		while (count < index) {
			count++;
			currentNode = currentNode.getNext();
		}
		return currentNode.getElement();
	}
	/**
	 * Este metodo agrega un nodo en la posicion que se desee
	 * @param index
	 * @param element
	 * @return
	 */
	public boolean addAt(long index, T element) {
		MyDoubleNode<T> node = new MyDoubleNode<T>(element);
		boolean flag = true;
		MyDoubleNode<T> currentNode = head;
		MyDoubleNode<T> previousNode = null;
		long currentIndex = 0;

		if (index > length || index < 0) {
			flag = false;
		}else if (index == 0) {
			node.setNext(currentNode);
			currentNode.setPrevious(node);
			head = node;
		} else {
			while (currentIndex < index) {
				currentIndex++;
				previousNode = currentNode;
				currentNode.setNext(currentNode.getNext());
				currentNode = currentNode.getNext();
			}
			node.setNext(currentNode);
			previousNode.setNext(node);
		}
		length++;
		return flag;
	}
	/**
	 * Este metodo retorna la posicion de una nodo segun el dato que le entra pos parametro
	 * @param data
	 * @return
	 */
	public long indexOf(T data){
		MyDoubleNode<T> currentNode = this.head;
		long index = -1;
		while(currentNode != null){
			index ++;
			if(currentNode.getElement() == data){
				return index;
			}
		currentNode = currentNode.getNext();
	}
		return -1;
	}
	
	
	/**
	 * Este metodo reemplaza un nodo en el index donde elijamos
	 * @param index
	 * @param element
	 * @return retorna verdadero si lo reemplazo, y falso si no
	 */
	public boolean replaceIndex(long index, T element) {
		MyDoubleNode<T> node = new MyDoubleNode<T>(element);
		boolean flag = true;
		MyDoubleNode<T> currentNode = head;
		MyDoubleNode<T> previousNode = null;
		long currentIndex = 0;

		if (index > this.size()|| index < 0) {
			flag = false;
		}else if (index == 0) {
			node.setNext(currentNode.getNext());
			currentNode.setPrevious(node);
			head = node;
		} else {
			while (currentIndex < index) {
				currentIndex++;
				previousNode = currentNode;
				currentNode.setNext(currentNode.getNext());
				currentNode = currentNode.getNext();
			}
			node.setNext(currentNode.getNext());
			previousNode.setNext(node);
		}
		length++;
		return flag;
	}
	
	/**
	 * este metodo elimina un nodo en una posicion que le entra por parametro
	 * @param index
	 * @return
	 */
	public T eliminateIndex(long index) {
		MyDoubleNode<T> node = new MyDoubleNode<T>();
		MyDoubleNode<T> currentNode = head;
		long currentIndex = 0;
		
		if(index > this.length || index < 0){
			return null;
		}
		
		if (index == 0) {
			node = this.head;
			this.head = this.head.getNext();
			return this.head.getElement();
		} else {
				do {
				currentIndex++;
				node = currentNode;
				currentNode = currentNode.getNext();
			}while (currentIndex <= index);
				this.remove(node.getElement());
		}
		
		return node.getElement();
	}

	
	public T getData(long index) {
		MyDoubleNode<T> node = new MyDoubleNode<T>();
		MyDoubleNode<T> currentNode = head;
		long currentIndex = 0;
		
		if(index > this.size() || index < 0){
			return null;
		}
		
		if (index == 0) {
			return this.head.getElement();
		} else {
				do {
				currentIndex++;
				node = currentNode;
				currentNode = currentNode.getNext();
			}while (currentIndex <= index);

		}
		
		return node.getElement();
	}
	
	public void printCollection() {
		MyDoubleNode<T> actual = head;
		System.out.print("[ ");
		while (actual != null) {
			System.out.print(actual.getElement() + " ");
			actual = actual.getNext();
		}
		System.out.println("]");
	}
}


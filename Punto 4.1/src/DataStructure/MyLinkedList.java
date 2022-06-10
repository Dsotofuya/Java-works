package DataStructure;

public class MyLinkedList <T>{
	private long size;
	private Node<T> head = null;
	
	
	public MyLinkedList() {
		this.size = 0;
	}
	
	public long size(){
		return size;
	}
	
	public void add(T data){
		Node<T> dataElement = new Node<T>(data);
		if(head == null){
			head = dataElement;
		}else{
			Node<T> currentNode = this.head;
			while(currentNode.getNext() != null){
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(dataElement);
		}
		this.size ++;
	}
	
	public void remove(T data){
		Node<T> currentNode = this.head;
		Node<T> previusNode = new Node<>();
		if(currentNode.getData() == data){
			this.head = currentNode.getNext();
		}else{
			while(currentNode.getData() != data){
				previusNode = currentNode;
				currentNode = currentNode.getNext();
			}
			previusNode.setNext(currentNode.getNext());
		}
		if(this.size > 0){
			this.size --;
		}
	}
	
	public long indexOf(T data){
		Node<T> currentNode = this.head;
		long index = -1;
		while(currentNode != null){
			index ++;
			if(currentNode.getData() == data){
				return index;
			}
		currentNode = currentNode.getNext();
	}
		return -1;
	}
	
	
	public T elementAt(long index){
		Node<T> currentNode = this.head;
		long count = 0;
		while(count < index){
			count ++;
			currentNode = currentNode.getNext();
		}
		return currentNode.getData();
	}
	
	public boolean addAt(long index,T data){
		Node<T> node = new Node<T>(data);
		boolean flag = true;
		Node<T> currentNode = this.head;
		Node<T> previusNode = null;
		long currenIndex =0;
		
		if(index == 0){
			node.setNext(currentNode);
			head = node;
		}else{
			while(currenIndex < index){
				currenIndex ++;
				previusNode = currentNode;
				currentNode.setNext(node.getNext());
			}
			node.setNext(currentNode.getNext());
			previusNode.setNext(node);
		}
		this.size ++;
		return flag;
	}
	
	public T removeAt(long index){
	    Node<T> currentNode = head;
	    Node<T> previousNode = null;
	    long currentIndex = 0;
	    if (index < 0 || index >= this.size){
	        return null;
	    }
	    if(index == 0){
	        head = currentNode.getNext();
	    } else {
	        while(currentIndex < index) {
	            currentIndex ++;
	            previousNode = currentNode;
	            currentNode = currentNode.getNext();
	        }
	        previousNode.setNext(currentNode.getNext());
	    }
	    this.size --;
	    return currentNode.getData();
	  }

	} 
	
//	public boolean isEmpty(){
//		
//	}

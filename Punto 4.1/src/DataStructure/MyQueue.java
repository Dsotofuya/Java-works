package DataStructure;

import java.util.ArrayList;

public class MyQueue <T>{
	private long size;
	private Node<T> head;
	

	public MyQueue() {
		this.size = 0;
		this.head = null;
	}
	
	public void enqueue(T data){
		Node<T> node = new Node<T>(data);
		if(this.head == null){
			head = node;
		}else{
			Node<T> currentNode = this.head;
			while(currentNode.getNext() != null){
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
		}
		this.size ++;
	}
	
	public T copyDequeue(){
		return head.getData();	
	}
	
	public T dequeue(){
		T element = null;
		if (head != null) {
			element = head.getData();
			head = head.getNext();
	}
		
		if(size > 0){
			size --;
		}
		return element;
	}
	
	public T front(){
		T element = null;
		if(head != null)
			element = head.getData();
			return element;
	}
	
	public long size(){
		Node actual = this.head;
		long cont = 0;
		while(actual != null){
			cont ++;
			actual = actual.getNext();
		}
		return cont;
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	public void print(){
		Node<T> actual = head;
		while(actual != null){
			System.out.println(actual.getData());
			actual = actual.getNext();
		}
	}
	
	public ArrayList<T> getQueue() {
		ArrayList<T> list = new ArrayList<T>();
		
		Node<T> actual = head;
		while(actual != null){
			list.add(actual.getData());
			actual = actual.getNext();
		}
		
		return list;
	}
	
}

package structure;

import java.util.ArrayList;

public class Queue<T> {
	private Node<T> first;
	private Node<T> last;
	private ArrayList<T> historial;
	private int size;

	public Queue() {
		this.first = null;
		this.last = null;
		this.size = 0;
		this.historial = new ArrayList<T>();
	}
	
	public void addToHistorial(T info){
		this.historial.add(info);
	}
	
	public boolean isEmpty(){
		return this.first ==null;
	}
	
	public void put(T info){
		if (!isEmpty()) {
			this.last.next = new Node<T>(info);
			this.last = this.last.next;
			this.size = size + 1; 
		}else{
			this.first = this.last = new Node<T>(info);
			this.size = size + 1; 
		}
	}
	
	public void menosSize(){
		this.size-=1;
	}
	
	public void colar(T info){
		if (!isEmpty()) {
			Node<T> node = new Node<T>(info, this.first);
			this.first = node;
			this.size = size + 1;
		}else{
			this.first = this.last = new Node<T>(info);
			this.size = size + 1;
		}
	}
	
	public void remove(T info){
		if (info != first.info) {
			Node<T> current = this.first;
			Node<T> before = this.first;
			while(current!=null && current.info !=info){
				before = current;
				current = current.next;
			}
			if (current!=null) {
				before.next = current.next;
				for (int i = 0; i < historial.size(); i++) {
					if (historial.get(i).equals(current)) {
						historial.remove(i);
					}
				}
			}
		}else{
			first = first.getNext();
		}
	}
	
	public void resetHistorial(){
		this.historial.clear();
		Node<T> current = this.first;
		while (current!=null) {
			historial.add(current.getInfo());
			current = current.next;
		}
	}
	public void deleteHistorials(){
		historial.clear();
	}
	
	public Node<T> getFirst(){
		return this.first;
	}
	
	public T get(){
		T aux = this.first.info;
		this.first = this.first.next;
		this.size = size - 1;
		return aux;
	}

	public int size() {
		return size;
	}

	public ArrayList<T> getHistorial() {
		return historial;
	}
	public void setFirst(Node<T> first) {
		this.first = first;
	}
}

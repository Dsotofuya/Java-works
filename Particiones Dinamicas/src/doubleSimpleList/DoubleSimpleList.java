package doubleSimpleList;

import java.util.ArrayList;

public class DoubleSimpleList<T> {

	private Node<T> head;
	private Node<T> last;
	private ArrayList<T> historial;

	public DoubleSimpleList() {
		this.head = null;
		this.last = null;
		this.historial = new ArrayList<T>();
	}

	public boolean isEmpty(){
		return this.head==null;
	}

	public void addToHistorial(T info){
		this.historial.add(info);
	}

	public void deleteHistorials(){
		historial.clear();
	}

	public void insert(T info){
		if (head !=null) {
			head.previus = new Node<T>(info, head, null);
			head = head.previus;
		}else{
			head = last =new Node<T>(info);
		}
	}
	
	public int getSize(){
		int count = 0;
		Node<T> current = this.head;
		while (current!=null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void add(T info){
		if (head!=null) {
			last.next = new Node<T>(info, null, last);
			last= last.next;
		}else{
			head = last =new Node<T>(info);
		}
	}

	public void add(Node<T>current,Node<T>current2){
		current2.next= current.next;
		current2.previus = current; 
		if (current.next != null) {
			current.next.previus = current2;
		}
		current.next = current2;
		this.historial.add(current2.getInfo());
	}
	
	public void addNextCondensation1(Node<T>current,Node<T>current2){
		current2.next= current.next.next;
		current2.previus = null;
		current.next.next.previus=current2;
		this.head = current2;
		this.historial.add(current2.getInfo());
	}
	
	public void addNextPartition(Node<T>current,Node<T>current2){
		current2.next= current.next;
		current2.previus = current.previus;
		if (current.next!=null) {
			current.next.previus=current2;
		}
		if (current2.previus==null) {
			this.head = current2;
		}
        if(current.previus!=null){
        	current.previus.next = current2;
        }
		this.historial.add(current2.getInfo());
	}
	
	public void addHeadPartition(Node<T>current2){
		this.head = current2;
	}

	public void addNextCondensation(Node<T>current,Node<T>current2){
		current2.next= current.next.next;
		current2.previus = current.previus;
		current.previus.next = current2;
		current.next.next.previus=current2;
		this.historial.add(current2.getInfo());
	}
	public void addPrevCondensation(Node<T>current,Node<T>current2){
		current2.next= current.next;
		current2.previus = current.previus.previus;
		current.next.previus = current2;
		current.previus.previus.next=current2;
		this.historial.add(current2.getInfo());
	}
	public void addPrevCondensation1(Node<T>current,Node<T>current2){
		current2.next= null;
		current2.previus = current.previus.previus;
		current.previus.previus.next=current2;
		this.historial.add(current2.getInfo());
	}
	
	public void print(){
		System.out.println("************************");
		Node<T> current = this.head;
		while (current!=null) {
			System.out.println(current.getInfo());
			current = current.next;
		}
		System.out.println("************************");
	}

	public void remove(T info){
		Node<T> current = head;
		while (info !=current.info && current !=null) {
			current = current.next;
		}
		if (current!=null) {

			if (current.info.equals(head.info)) {
				head.next.previus = null;
				head = head.next;
			}else if (current.info.equals(last.info)) {
				last.previus.next = null;
				last = last.previus;
			}else{
				current.next.previus = current.previus;
				current.previus.next = current.next;
			}
		}
	}
	
	public void reset(){
		this.historial.clear();
	}

	public Node<T> getHead() {
		return head;
	}

	public Node<T> getLast() {
		return last;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public void setLast(Node<T> last) {
		this.last = last;
	}

	public ArrayList<T> getHistorial() {
		return historial;
	}
}
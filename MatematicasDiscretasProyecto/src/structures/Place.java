package structures;

public class Place<T> {

	private T data;
	private Place<T> next;
	
	public Place(T data) {
		this.data = data;
	}
	
	public T getData(){
		return data;
	}
	
	public Place<T> getNext() {
		return next;
	}
	
	public void setNext(Place<T> next) {
		this.next = next;
	}
}

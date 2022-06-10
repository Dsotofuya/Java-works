package structures;

import java.util.Comparator;

public class Queue<T> implements Iterable<T>{

	private Place<T> head;
	private Comparator<T> comparator;

	public Queue(Comparator<T> comparator) {
		head = null;
		this.comparator = comparator;
	}

	public void push(T data) {
		if (head == null) {
			head = new Place<T>(data);
		} else {
			Place<T> actual = head;
			while (actual.getNext() != null) {
				actual = actual.getNext();
			}
			actual.setNext(new Place<T>(data));
		}
	}

	public void poll() throws NullPointerException {
		try {
			if (!isEmpty()) {
				head = head.getNext();
			}
		} catch (Exception e) {
		}
	}

	public T peek() {
		return head.getData();
	}

	public boolean exist(T data) throws NullPointerException {
		boolean existence = false;
		try {
			Place<T> actual = head;
			while (actual != null && !existence) {
				if (comparator.compare(actual.getData(), data) == 0) {
					existence = true;
				}
				actual = actual.getNext();
			}
		} catch (Exception e) {
		}
		return existence;
	}

	public boolean isEmpty() {
		return head == null;
	}
	
	public Place<T> getHead(){
		return head;
	}

	@Override
	public QueueIterator<T> iterator() {
		return new QueueIterator<T>(this);
	}
}

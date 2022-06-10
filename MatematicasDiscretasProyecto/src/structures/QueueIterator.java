package structures;

import java.util.Iterator;

public class QueueIterator<T> implements Iterator<T>{
	
	
	private Place<T> localHead;
	public QueueIterator(Queue<T> queue) {
		this.localHead = queue.getHead();
	}

	@Override
	public boolean hasNext() throws NullPointerException{
		try {
			return (localHead.getData() != null);		
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public T next() {
		T actual = localHead.getData();
		localHead = localHead.getNext();
		return actual;
	}

}

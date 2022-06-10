package modelsBatchMono;

import DataStructure.MyQueue;

public class Program {
	
	private String name;
	private MyQueue<Batch> queueBatch;
	
	public Program(String name) {
		this.queueBatch = new MyQueue<Batch>();
		this.name = name;
		init((int) (Math.random() * (5 - 1)) + 1);
	}

	public Program(String name, MyQueue<Batch> queueBatch) {
		this.name = name;
		this.queueBatch = queueBatch;
	}

	private void init(int cant) {
		for (int i = 0; i < cant; i++) {
			this.queueBatch.enqueue(new Batch());
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyQueue<Batch> getQueueBatch() {
		return queueBatch;
	}

	public void setQueueBatch(MyQueue<Batch> queueBatch) {
		this.queueBatch = queueBatch;
	}
	

}

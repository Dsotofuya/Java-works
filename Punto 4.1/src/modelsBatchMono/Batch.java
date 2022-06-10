package modelsBatchMono;

import DataStructure.MyQueue;

public class Batch {
	
	private MyQueue<Sentence> queueSentence;
	
	
	public Batch() {
		this.queueSentence = new MyQueue<Sentence>();
		init(5);
	}
	

	public Batch(MyQueue<Sentence> queueSentence) {
		super();
		this.queueSentence = queueSentence;
	}
	
	private void init(int cant) {
		for (int i = 0; i < cant; i++) {
			this.queueSentence.enqueue(new Sentence(i+"", EnumSentence.values()[(int) (Math.random() * ( EnumSentence.values().length- 0)) + 0], (long) 2000));
		}
	}
	
	public Long getNumSentences() {
		return this.queueSentence.size();
	}


	public MyQueue<Sentence> getQueueSentence() {
		return queueSentence;
	}


	public void setQueueSentence(MyQueue<Sentence> queueSentence) {
		this.queueSentence = queueSentence;
	}
	
	

}

package modelsBatchMono;

public class Description {
	
	private String owner;
	private Sentence sentence;
	
	
	public Description() {
	}


	public Description(String owner, Sentence sentence) {
		this.owner = owner;
		this.sentence = sentence;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public Sentence getSentence() {
		return sentence;
	}


	public void setSentence(Sentence sentence) {
		this.sentence = sentence;
	}
	
	
	
}

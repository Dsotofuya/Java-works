package modelsBatchMono;

public class Sentence implements Runnable{
	
	private String sentence;
	private EnumSentence enumSentence;
	private Long timeExecution;
	
	
	public Sentence() {
		// TODO Auto-generated constructor stub
	}

	public Sentence(String sentence, EnumSentence enumSentence, Long timeExecution) {
		this.sentence = sentence;
		this.enumSentence = enumSentence;
		this.timeExecution = timeExecution;
	}
	
	
	@Override
	public void run() {
		
		
		
	}
	
	
	public String getSentence() {
		return sentence;
	}


	public void setSentence(String sentence) {
		this.sentence = sentence;
	}


	public EnumSentence getEnumSentence() {
		return enumSentence;
	}


	public void setEnumSentence(EnumSentence enumSentence) {
		this.enumSentence = enumSentence;
	}


	public Long getTimeExecution() {
		return timeExecution;
	}


	public void setTimeExecution(Long timeExecution) {
		this.timeExecution = timeExecution;
	}

}

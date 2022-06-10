package modelsBatchMono;

public class Finish {
	
	private String nameprogram;
	private Long bash;
	private EnumSentence enumSentence;
	
	
	public Finish() {
		
	}


	public Finish(String nameprogram, Long bash, EnumSentence enumSentence) {
		super();
		this.nameprogram = nameprogram;
		this.bash = bash;
		this.enumSentence = enumSentence;
	}


	public String getNameprogram() {
		return nameprogram;
	}


	public void setNameprogram(String nameprogram) {
		this.nameprogram = nameprogram;
	}


	public Long getBash() {
		return bash;
	}


	public void setBash(Long bash) {
		this.bash = bash;
	}


	public EnumSentence getEnumSentence() {
		return enumSentence;
	}


	public void setEnumSentence(EnumSentence enumSentence) {
		this.enumSentence = enumSentence;
	}
	
	
	
}

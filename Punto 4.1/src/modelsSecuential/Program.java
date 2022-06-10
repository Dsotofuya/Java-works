package modelsSecuential;


/**
 * Esta clase representa los datos de un programa en esta implementación
 * @author herna
 *
 */
public class Program{
	private String name;
	private String utilities;
	private Boolean isFail;
	private String [] sentences;
	
	
	//Contructor de clase
	public Program() {
		
	}

	//Contructor de clase
	public Program(String name, String utilities,String [] sentences) {
		this.name = name;
		this.utilities = utilities;
		this.isFail = false;
		this.sentences = sentences;
	}
	

	
	//////// GETTERS AND SETTERS
	public String getNameProgram() {
		return name;
	}

	public void setNameProgram(String name) {
		this.name = name;
	}

	public String getUtilities() {
		return utilities;
	}

	public void setUtilities(String utilities) {
		this.utilities = utilities;
	}

	public Boolean getIsFail() {
		return isFail;
	}

	public void setIsFail(Boolean isFail) {
		this.isFail = isFail;
	}
	

	public String[] getSentences() {
		return sentences;
	}

	public void setSentences(String[] sentences) {
		this.sentences = sentences;
	}

	@Override
	public String toString() {
		return "name program: " + this.name + "  /  utilidades: " + this.utilities;
	}

}

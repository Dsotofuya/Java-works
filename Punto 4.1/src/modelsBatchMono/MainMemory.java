package modelsBatchMono;

import java.util.ArrayList;

public class MainMemory {
	
	private ArrayList<Description> userMemory;
	private ArrayList<Description> monitormemory;
	
	public MainMemory() {
		this.userMemory = new ArrayList<Description>();
		this.monitormemory = new ArrayList<Description>();
	}
	
	
	public void validateSentence(String nameProgram,Sentence sentence) {
		if (sentence.getEnumSentence().name() == EnumSentence.PROGRAMA.name()) {
			this.userMemory.add(new Description(nameProgram, sentence));
		}else {
			this.monitormemory.add(new Description(nameProgram, sentence));
		}
	}
	
	public void resetMonitor() {
		this.monitormemory.clear();
		this.userMemory.clear();
	}

	public ArrayList<Description> getUserMemory() {
		return userMemory;
	}

	public void setUserMemory(ArrayList<Description> userMemory) {
		this.userMemory = userMemory;
	}

	public ArrayList<Description> getMonitormemory() {
		return monitormemory;
	}

	public void setMonitormemory(ArrayList<Description> monitormemory) {
		this.monitormemory = monitormemory;
	}
	
}

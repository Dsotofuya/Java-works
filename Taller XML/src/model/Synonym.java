package model;

import java.util.ArrayList;

public class Synonym {
	
	public void setWords(ArrayList<String> words) {
		this.words = words;
	}

	private ArrayList<String> words;

	public Synonym() {
		words = new ArrayList<String>();
	}
	
	public boolean findWord(String wordToSearch) {
		boolean wordFound = false;
		for (String word : words) {
			if (wordToSearch.equalsIgnoreCase(word.toString())) {
				wordFound = true;
			}
		}
		return wordFound;
	}
	
	public void addWord(String word) {
		words.add(word);
	}
	
	public ArrayList<String> getWord() {
		return words;
	}

	@Override
	public String toString() {
		return "Words: " + words;
	}
	
	
	
	
}

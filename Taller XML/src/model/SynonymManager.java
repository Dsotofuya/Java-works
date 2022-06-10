package model;

import java.util.ArrayList;

import model.dao.XMLdao;

public class SynonymManager {
	
	private XMLdao xmlDates;
	private ArrayList<Synonym> synonymsList;
	private Synonym synonym;
	
	public SynonymManager() {
		synonym = new Synonym();
		xmlDates = new XMLdao();
		synonymsList = xmlDates.loadXMLDates();
		
	}

	public Synonym findSynonyms(String wordToSearch) {
		Synonym synonymsFound = null;
		for (Synonym synonym : synonymsList) {
			boolean xd = synonym.findWord(wordToSearch);
			if (xd == true) {
				synonymsFound = synonym;
			}
		}
		return synonymsFound;
	}
	
	public void writeXml() {
		xmlDates.write(synonymsList);
	}
	
	public void addWord(String word) {
		synonym.addWord(word);
	}
	
	public ArrayList<Synonym> getSynonymsList() {
		return synonymsList;
	}

	public Synonym getSynonym() {
		return synonym;
	}

	public void addSynonym(Synonym synonym) {
		synonymsList.add(synonym);
	}

	public int countSynonymsAvaliable(Synonym synonym) {
		return synonym.getWord().size()-1;
	}

	public void setNewSynonym() {
		this.synonym = new Synonym();	
	}
		
}

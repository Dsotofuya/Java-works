package model;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	@SuppressWarnings("resource")
	public Synonym createNewWord(Synonym synonym, String word) {
		System.out.println("aniadida la palabra: " + word);
		synonym.addWord(word);
		Scanner scanner = new Scanner(System.in);
		System.out.println("mas palabras?");
		String var = scanner.nextLine();
		if (var.equalsIgnoreCase("Si")) {
			createNewWord(synonym, scanner.nextLine());
		}
		return synonym;
	}
	
	public Synonym addWord(String word) {
		synonym.addWord(word);
		return synonym;
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
	
//	public static void main(String[] args) {
//		SynonymManager xd = new SynonymManager();
//		xd.showDates();
//		xd.addSynonym(xd.createNewWord(new Synonym(), "mango"));
//		xd.addSynonym(xd.createNewWord(new Synonym(), "perro"));
//		xd.showDates(); 
//		xd.findSynonyms("mango");
//		System.out.println(xd.countSynonymsAvaliable(xd.findSynonyms("chistoso")));
//		}
//	
}

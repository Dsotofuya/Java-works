package model.dao;

import java.util.ArrayList;

import model.palabra;

public class controlPalabra {

	public ArrayList<palabra> palabras;
	
	public controlPalabra() {
		palabras = new ArrayList<palabra>();
		init();
	}

	public String buscarPalabraIngles(String palabraIngles) {
			String wordEglish = "";
			for (palabra palabraEspañol : palabras) {
				if (palabraEspañol.getPalabra().equalsIgnoreCase(palabraIngles)) {
					wordEglish = palabraEspañol.getTraduccionIngles();
				}
			}
			return wordEglish;
		}
	
	public String buscarPalabraFrances(String palabraFrances) {
		String wordFrances = "";
		for (palabra palabraEspañol : palabras) {
			if (palabraEspañol.getPalabra().equalsIgnoreCase(palabraFrances)) {
				wordFrances = palabraEspañol.getTraduccionFrances();
			}
		}
		return wordFrances;
	}

	public void addNewWord(String palabra, String traduccionIngles, String traduccionFrances) {
		palabras.add(new palabra(palabra, traduccionIngles, traduccionFrances));
	}
	
	public int nEnglishWords() {
		int contador = 0;
		for (palabra palabra : palabras) {
			if (palabra.getTraduccionIngles() != null && !palabra.getTraduccionIngles().isEmpty() 
					&& palabra.getTraduccionIngles() != "") {
				contador++;
			}
		}
		return contador;
	}
	
	public int nFrenchhWords() {		int contador = 0;
		for (palabra palabra : palabras) {
			if (palabra.getTraduccionFrances() != null && !palabra.getTraduccionFrances().isEmpty() 
					&& palabra.getTraduccionFrances() != "") {
				contador++;
			}
		}
		return contador;
	}
	
	private void init() {
		addNewWord("Carro", "Car", "Chariot");
		addNewWord("Casa", "House", "");
		addNewWord("mango", "", "Mangue");
	}
	
	
	
}

package model.dao;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Synonym;

public class WriteHandler extends DefaultHandler {

	private String text;
	private ArrayList<Synonym> synonyms;

	public WriteHandler(ArrayList<Synonym> synonyms) {
		this.synonyms = synonyms;
		text = new String();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("dictionary")) {
			text += "<" + qName + ">";
			for (Synonym synonym : synonyms) {
				insertSynonym(synonym.getWord());
			}
		} else {
			text += "<" + qName + ">";
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		text += "</" + qName + ">";
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text += new String(ch, start, length);
		super.characters(ch, start, length);
	}

	public void insertWord(String word) throws SAXException {
			startElement(null, null, "synonym", null);
			characters(word.toCharArray(), 0, word.length());
			endElement(null, null, "synonym");
	}
	
	public void insertSynonym(ArrayList<String> synonyms) throws SAXException {
		startElement(null, null, "synonyms", null);
		for (String word : synonyms) {
			insertWord(word);
		}
		endElement(null, null, "synonyms");
	}
	
	public String getText() {
		return text;
	}

}

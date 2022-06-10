package model.dao;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Synonym;

public class ReadHandler extends DefaultHandler {
	
	private ArrayList<Synonym> synonymList = new ArrayList<Synonym>();
	private Synonym synonym;
	private StringBuffer buffer = new StringBuffer();
	
	public ArrayList<Synonym> getSynonymList() {
		return synonymList;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		buffer.append(ch, start, length);
		super.characters(ch, start, length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "synonym": 
				synonym.addWord(buffer.toString());
			break;
		default:
			break;
		}
		super.endElement(uri, localName, qName);
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName) {
		case "synonyms":
			synonym = new Synonym();
			synonymList.add(synonym);
			break;
		case "synonym": 
			buffer.delete(0, buffer.length());
			break;
		default:
			break;
		}
		super.startElement(uri, localName, qName, attributes);
	}
}

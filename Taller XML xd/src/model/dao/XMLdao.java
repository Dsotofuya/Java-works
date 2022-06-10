package model.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Synonym;

public class XMLdao extends DefaultHandler {
	
	private ArrayList<Synonym> synonymList;
	
	//https://www.youtube.com/watch?v=CaF8w9RjVac
	
	
	
	public ArrayList<Synonym> loadXMLDates() {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			SynonymsHandler sh = new SynonymsHandler();
			saxParser.parse(new File("data/persistence data/SynonymsDictionary.xml"), sh );
			synonymList = sh.getSynonymList();
			for (Synonym synonym : synonymList) {
				System.out.println(synonym.toString());
			}
		} catch (ParserConfigurationException | SAXException  | IOException e) {
			e.printStackTrace();
		}
		return synonymList;
	}
	
	public static void main(String[] args) {
		new XMLdao().loadXMLDates();
	}
}

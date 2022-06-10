package model.dao;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;
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
			ReadHandler sh = new ReadHandler();
			saxParser.parse(new File("data/SynonymsDictionary.xml"), sh );
			synonymList = sh.getSynonymList();
			for (Synonym synonym : synonymList) {
				System.out.println(synonym.toString());
			}
		} catch (ParserConfigurationException | SAXException  | IOException e) {
			e.printStackTrace();
		}
		return synonymList;
	}
	
	
	public void write(ArrayList<Synonym> synonyms) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			WriteHandler writeHandler = new WriteHandler(synonyms);
			saxParser.parse(new File("data/persistence data/SynonymsDictionary.xml"), writeHandler);
			System.out.println(writeHandler.getText());
			
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}ident-amount", "4");
			SAXSource saxSource = new SAXSource(new InputSource(new StringReader(writeHandler.getText())));
			transformer.transform(saxSource, new StreamResult(new File("data/datos_new.xml")));
		} catch (ParserConfigurationException  | SAXException  | IOException | TransformerException e) {
			e.printStackTrace();
		}
	}
}

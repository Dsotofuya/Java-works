package saxXml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import model.Book;

public class MyHandler extends DefaultHandler {
	private String text;
	private Book book;
	
	public MyHandler(Book book) {
		text = new String();
		this.book = book;
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attibutes) {
		if (qName.equals("libros")) {
			text += "<" + qName + ">";
			insert(book);
		}else {
			text += "<" + qName + ">";
		}
		
	}
	
	public void insert(Book book) {
		startElement(null, null, "libro", null);
		startElement(null, null, "titulo", null);
		characters(book.getTittle().toCharArray(), 0, book.getTittle().length());
		endElement(null, null, "titulo");
		startElement(null, null, "autor", null);
		characters(book.getAutor().toCharArray(), 0, book.getAutor().length());
		endElement(null, null, "autor");
		endElement(null, null, "libro");
	}

	public void endElement(String uri, String localName, String qName) {
		text += "</" + qName + ">";
	}
	
	public void characters(char[] ch, int start, int length) {
		text += new String(ch, start, length);
	}
	
	public String getText() {
		return text;
	}
}

package saxXml;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

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

import model.Book;

public class TestHandler {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		MyHandler handler = new MyHandler(new Book("estructuras de datos","Zahonero"));
		sp.parse(new File("datos.xml"), handler);
		System.out.println(handler.getText());
		save(handler.getText());
	}
	
	public static void save(String text) throws TransformerException {
		TransformerFactory trans = TransformerFactory.newInstance();
		Transformer tra = trans.newTransformer();
		tra.setOutputProperty(OutputKeys.INDENT, "yes");
		tra.setOutputProperty("{http://xml.apache.org/xslt}ident-amount", "4");
		InputSource in = new InputSource(new StringReader(text));
		SAXSource source = new SAXSource(in);
		tra.transform(source, new StreamResult(new File("datos_new.xml")));
		
	}

}

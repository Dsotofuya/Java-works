package Dao;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class readXML {

	public readXML() {
		File file = new File("src/zData/Ejemplo 1.xml");
		DocumentBuilderFactory dBF =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = dBF.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println("root element" + doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("meme");
			for (int i = 0; i < nodeList.getLength(); i++) {
				getMeme(nodeList.item(i));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public void getMeme(Node node){ 
			System.out.println(node.getNodeName()); 
			if(node.getNodeType()==Node.ELEMENT_NODE){ 
				Element element = (Element)node;
				System.out.println(element.getAttribute("id"));
				System.out.println(getTagValue("frase",element));
				System.out.println(getTagValue("autor",element));
				System.out.println(getTagValue("anio",element));
				} 
		}
		
		public String getTagValue(String tag, Element element){ 
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodeList.item(0);
		return node.getNodeValue();
		}
		
		public static void main(String[] args) {
			new readXML();
		}
}

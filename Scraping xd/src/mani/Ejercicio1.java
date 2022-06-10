package mani;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ejercicio1 {
	public static void main(String[] args) {
		File input = new File("src/scrap/index.html");
		Document doc;
		try {
			doc = Jsoup.parse(input, "UTF-8", "https://www.semana.com/");
			Elements divs = doc.getElementsByClass("row collapse");
			for (Element element : divs) {
				String xd = element.getElementsByClass("section-tag").first().text();
				System.out.println(xd);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

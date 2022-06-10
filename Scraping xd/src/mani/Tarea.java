package mani;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Tarea {

	public static void main(String[] args) {
		File input = new File("src/scrap/YouTube.html");
		Document doc;
		try {
			doc = Jsoup.parse(input, "UTF-8", "https://www.youtube.com/");
			// Select: selecciona el elemento, attr recibe la etiqueta a agregar y el
			// argumento
			doc.select("yt-icon-button").attr("style", "background:red");
			doc.select("yt-simple-endpoint style-scope ytd-mini-guide-entry-renderer").attr("style", "background:red");
			Element xd= doc.select("avatar-link").select("style-scope yt-img-shadow").first();
			System.out.println(xd);
			Elements divs = doc.getElementsByClass("style-scope ytd-thumbnail-overlay-time-status-renderer");
			LocalTime min = LocalTime.parse("00:01:00");
//			for (Element element : divs) {
//				String time = element.getElementsByClass("style-scope ytd-thumbnail-overlay-time-status-renderer")
//						.first().text();
//				if (time != " ") {
//					LocalTime vidTime = LocalTime.parse(time);
//					if (ChronoUnit.MINUTES.between(min, vidTime) > 1) {
//						doc.select("style-scope ytd-thumbnail-overlay-time-status-renderer").attr("style",
//								"background:red");
//					}
//				}
//			}
			File f = new File("src/scrap/filename.html");
			BufferedWriter a = new BufferedWriter(new FileWriter(f));
			a.write(doc.toString());
			a.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

package model.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Episode;

public class WebService {

	private ArrayList<Episode> episodeList;

	public WebService() {
		episodeList = listEspisodes(WebServicePlainReader(
				"http://api.tvmaze.com/singlesearch/shows?q=game-of-thrones&embed=episodes"));
	}

	public JSONObject WebServicePlainReader(String url) {
		URL obj;
		StringBuffer response = null;
		try {
//		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection(/* proxy */ );
			int responseCode = con.getResponseCode();
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("error en conexion " + e.getMessage());
		}
		JSONObject objJSON = new JSONObject(response.toString());
		return objJSON;
	}
	
	public ArrayList<Episode> listEspisodes(JSONObject objJSON) {
		ArrayList<Episode> episodeList = new ArrayList<>();
		JSONObject appList = objJSON.getJSONObject("_embedded");
		JSONArray apps = appList.getJSONArray("episodes");
		Iterator<?> iterator = apps.iterator();
		while (iterator.hasNext()) {
			JSONObject episode	 = (JSONObject) iterator.next();
			int id = episode.getInt("id");
			String name = episode.getString("name");
			int season = episode.getInt("season");
			int number = episode.getInt("number");
			String airdate = episode.getString("airdate");
			String summary = episode.getString("summary");
			Episode newEpisode = new Episode(id, name, season, number, airdate, summary.replaceAll("\\<.*?>",""));
			episodeList.add(newEpisode);
		}
		return episodeList;
	}

	public ArrayList<Episode> getEpisodeList() {
		return episodeList;
	}
}

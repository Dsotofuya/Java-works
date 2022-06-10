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

import model.Game;
import model.GameSpecs;

public class WebService {

	private ArrayList<Game> gameList;

	public WebService() {
		gameList = listObjects(WebServicePlainReader(
				"http://api.steampowered.com/ISteamApps/GetAppList/v2"));
	}

	public JSONObject WebServicePlainReader(String url) {
		URL obj;
		StringBuffer response = null;
		try {
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection( proxy );
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

	public JSONObject searchGame(String id) {
		URL obj;
		StringBuffer response = null;
		try {
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
			obj = new URL("https://store.steampowered.com/api/appdetails?appids=" + id);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection(proxy);
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
		JSONObject objJson =  new JSONObject(response.toString());
		return objJson;
	}
	
	public GameSpecs getGameSpecs(JSONObject objJson, String id) {
		JSONObject specsGame = objJson.getJSONObject(id);
		JSONObject data = (JSONObject) specsGame.get("data");
		String img = data.getString("header_image");
		String description = data.getString("detailed_description");
		JSONObject pcRequirements = data.getJSONObject("pc_requirements");
		String minimum = pcRequirements.getString("minimum");
		GameSpecs specs = new GameSpecs(img, description.replaceAll("\\<.*?>",""), minimum.replaceAll("\\<.*?>",""));
		return specs;
	}
	
	public ArrayList<Game> listObjects(JSONObject objJSON) {
		ArrayList<Game> gameList = new ArrayList<>();
		JSONObject appList = objJSON.getJSONObject("applist");
		JSONArray apps = appList.getJSONArray("apps");
		Iterator<?> iterator = apps.iterator();
		while (iterator.hasNext()) {
			JSONObject app = (JSONObject) iterator.next();
			int appId = app.getInt("appid");
			String name = app.getString("name");
			Game newGame = new Game(appId, name);
			gameList.add(newGame);
		}
		return gameList;
	}

	public ArrayList<Game> getGameList() {
		gameList.remove(0);
		gameList.remove(1);
		gameList.remove(2);
		return gameList;
	}
	
}

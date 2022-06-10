package network.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import network.Request;

public class ServerServices implements Runnable {

	private Thread thread;
	private boolean serverOn;
	private ServerSocket server;

	public ServerServices() throws IOException {
		server = new ServerSocket(1234);
		thread = new Thread(this);
		thread.start();
		serverOn = true;
		Logger.getGlobal().log(Level.INFO, "Server 1234: On");
	}

	@Override
	public void run() {
		while (serverOn) {
			try {
				Socket connection = server.accept();
				Logger.getGlobal().log(Level.INFO, "New connection: " + connection.getInetAddress().getHostName());
				DataInputStream input = new DataInputStream(connection.getInputStream());
				DataOutputStream output = new DataOutputStream(connection.getOutputStream());
				Request req = Request.valueOf(input.readUTF());
				switch (req) {
				case generic:
					responseUser(input, output);
					break;
				default:
					break;
				}
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}
	}

	private void responseUser(DataInputStream input, DataOutputStream output) throws IOException, ParseException {
		String data = input.readUTF();
		JSONParser parser = new JSONParser();
		JSONObject request = (JSONObject) parser.parse(data);
		String bobject = (String) request.get("object");
//		output.writeUTF(listObjects(connectToITunes(processArtistName(bobject))).toJSONString());
	}

	private static JSONObject connectTos(String artist) throws ParseException {
		URL obj;
		StringBuffer response = null;
		try {
//			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
			obj = new URL("url" + artist);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection(/* proxy */);
			int responseCode = con.getResponseCode();
			Logger.getGlobal().log(Level.INFO, "Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (IOException e) {
			Logger.getGlobal().log(Level.INFO, "error en conexion " + e.getMessage());
		}
		JSONParser parser = new JSONParser();
		return (JSONObject) parser.parse(response.toString());
	}

	@SuppressWarnings("unchecked")
//	public JSONArray listObjects(JSONObject objJSON) {
//		JSONArray songList = new JSONArray();
//		JSONArray songs = (JSONArray) objJSON.get("results");
//		Iterator<?> iterator = songs.iterator();
//		for (int i = 0; i < nSongs; i++) {
//			JSONObject song = (JSONObject) iterator.next();
//			JSONObject songJSON = new JSONObject();
//			songJSON.put("name", (String) song.get("trackName"));
//			songJSON.put("url", (String) song.get("artworkUrl100"));
//			songList.add(songJSON);
//		}
//		return songList;
//	}

	private static String processArtistName(String nameArtist) {
		return nameArtist.replace(" ", "+");
	}

	public static void main(String[] args) throws ParseException {
		try {
			new ServerServices();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

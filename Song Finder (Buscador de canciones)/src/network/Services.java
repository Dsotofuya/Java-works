package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Song;

public class Services {

	private static final String HOST = "localhost";
//	private static final String HOST = "10.4.74.191";
	
	@SuppressWarnings("unchecked")
	public ArrayList<Song> findArtist(String artist, int nSongs) throws UnknownHostException, IOException {
		ArrayList<Song> auxList = new ArrayList<Song>();
		Socket socket = new Socket(HOST, 1234);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeUTF(Request.FIND.toString());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("artist", artist);
		jsonObject.put("nSongs", nSongs);
		output.writeUTF(jsonObject.toJSONString());
		getSongsFormServer(auxList, socket);
		socket.close();
		return auxList;
	}

	private void getSongsFormServer(ArrayList<Song> auxList, Socket socket) throws IOException {
		DataInputStream inputStream = new DataInputStream(socket.getInputStream());
		try {
			String data = inputStream.readUTF();
			JSONParser parser = new JSONParser();
			JSONArray songList = (JSONArray) parser.parse(data);
			Iterator<?> iterator = songList.iterator();
			while (iterator.hasNext()) {
				JSONObject song = (JSONObject) iterator.next();
				String name = (String) song.get("name");
				String url = (String) song.get("url");
				auxList.add(new Song(name, url));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}

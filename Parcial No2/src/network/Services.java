package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Services {

	private static final String HOST = "localhost";
//	private static final String HOST = "10.4.74.191";

	@SuppressWarnings("unchecked")
	public void generic() throws UnknownHostException, IOException, ParseException {
		Socket socket = new Socket(HOST, 1234);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		DataInputStream inputStream = new DataInputStream(socket.getInputStream());
		output.writeUTF(Request.generic.toString());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("key", "value");
		output.writeUTF(jsonObject.toJSONString());
		String data = inputStream.readUTF();
		JSONParser parser = new JSONParser();
		JSONArray objList = (JSONArray) parser.parse(data);
		Iterator<?> iterator = objList.iterator();
		while (iterator.hasNext()) {
			JSONObject obj = (JSONObject) iterator.next();
			String item = (String) obj.get("item");
			socket.close();
		}
	}

}
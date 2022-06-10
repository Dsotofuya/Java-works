package network.punto1;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.User;
import network.Request;

public class Services {

	private static final String HOST = "localhost";

	private static final String PATH = "src/images/";

	public ArrayList<User> requestList() throws UnknownHostException, IOException {
		ArrayList<User> auxList = new ArrayList<User>();
		Socket socket = new Socket(HOST, 1234);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeUTF(Request.GETLIST.toString());
		DataInputStream inputStream = new DataInputStream(socket.getInputStream());
		int count = inputStream.readInt();
		for (int i = 0; i < count; i++) {
			try {
				String data = inputStream.readUTF();
				JSONParser parser = new JSONParser();
				JSONObject post = (JSONObject) parser.parse(data);
				long id = (Long) post.get("id");
				String name = (String) post.get("name");
				Long number = (Long) post.get("number");
				auxList.add(new User(id, name,
						processImage(inputStream.readNBytes((int) ((long) post.get("imageLength"))), i), number));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		socket.close();
		return auxList;
	}

	private String processImage(byte[] image, int name) {
		ByteArrayInputStream bis = new ByteArrayInputStream(image);
		BufferedImage bufferedImage;
		String path = PATH + name + ".png";
		try {
			bufferedImage = ImageIO.read(bis);
			ImageIO.write(bufferedImage, "png", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
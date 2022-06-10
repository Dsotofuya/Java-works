package network;

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

import model.Post;

public class Services {

//	private static final String HOST = "192.168.1.8";
	private static final String HOST = "localhost";

	private static final String PNG = ".png";
	private static final String PATH = "src/images/";

	@SuppressWarnings("unchecked")
	public void addPost(String tittle, byte[] image, String description, int phone)
			throws UnknownHostException, IOException {
		Socket socket = new Socket(HOST, 3333);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeUTF(Request.ADD_POST.toString());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("imageLength", image.length);
		jsonObject.put("title", tittle);
		jsonObject.put("description",description);
		jsonObject.put("phone", phone);
		output.writeUTF(jsonObject.toJSONString());
		System.out.println(jsonObject.toJSONString());
		output.write(image);
		socket.close();
	}

	public void contact() throws UnknownHostException, IOException {
		Socket socket = new Socket(HOST, 3333);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeUTF(Request.CONCTACT.toString());
		socket.close();
	}

	public ArrayList<Post> requestList() throws UnknownHostException, IOException {
		ArrayList<Post> auxList = new ArrayList<Post>();
		Socket socket = new Socket(HOST, 3333);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeUTF(Request.REQUEST_LIST.toString());
		DataInputStream inputStream = new DataInputStream(socket.getInputStream());
		int xd = inputStream.readInt();
		for (int i = 0; i < xd; i++) {
			try {
				String data = inputStream.readUTF();
				JSONParser parser = new JSONParser();
				JSONObject post = (JSONObject) parser.parse(data);
				Long id = (Long) post.get("id");
				String title = (String) post.get("title");
				String description = (String) post.get("description");
				Long phone = (long) post.get("phone");
				auxList.add(new Post(id, title,
						processImage(inputStream.readNBytes((int) ((long) post.get("imageLength"))), String.valueOf(i)),
						description, phone));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		socket.close();
		return auxList;
	}

	public void notifyUser() throws IOException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				listenMessage();
			}
		});
		thread.start();
	}

	private void listenMessage() {
		Socket socket;
		try {
			socket = new Socket(HOST, 3333);
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			if (inputStream.available() > 0) {
				System.out.println(inputStream.readUTF());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String processImage(byte[] image, String name) {
		ByteArrayInputStream bis = new ByteArrayInputStream(image);
		BufferedImage bufferedImage;
		String path = PATH + name + PNG;
		try {
			bufferedImage = ImageIO.read(bis);
			ImageIO.write(bufferedImage, "png", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}

package network.server.punto1;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import model.Manager;
import model.User;
import network.Request;

public class ServerServices implements Runnable {

		private Thread thread;
		private boolean serverOn;
		private ServerSocket server;
		private Manager manager;

		public ServerServices() throws IOException {
			manager = new Manager();
			test();
			server = new ServerSocket(1234);
			thread = new Thread(this);
			thread.start();
			serverOn = true;
			Logger.getGlobal().log(Level.INFO, "Server 1234: On");
		}
		
		private void test() {
			manager.addPost(new User(0, "pepe", "src/data/icon.png", 5));
			manager.addPost(new User(0, "la rana", "src/data/icon.png", 8));
			manager.addPost(new User(0, "xdxd", "src/data/icon.png", 9));
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
					case GETLIST:
						sendPostList(connection, output);
						break;
					default:
						break;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		@SuppressWarnings("unchecked")
		private void sendPostList(Socket connection, DataOutputStream output) throws IOException {
			output.writeInt(manager.getUserList().size());
			System.out.println(manager.getUserList().size());
			for (User user : manager.getUserList()) {
				byte[] image = processImageToSend(user.getPhoto());
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("imageLength", image.length);
				jsonObject.put("id", user.getId());
				jsonObject.put("name", user.getName());
				jsonObject.put("number",user.getNumber());
				output.writeUTF(jsonObject.toJSONString());
				output.write(image);
			}
			Logger.getGlobal().log(Level.INFO, connection.getPort() + "has requested the post list");
		}
		
		private byte[] processImageToSend(String path) {
			byte[] image = null;
			try {
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
			    ImageIO.write(ImageIO.read(new File(path)), "png", bos );
			    image = bos.toByteArray();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return image;
		}

	public static void main(String[] args) throws ParseException {
		try {
			new ServerServices();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

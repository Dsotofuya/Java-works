package network;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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

import model.Post;
import model.PostManager;

public class Server implements Runnable {

	private static final String PNG = ".png";
	private static final String PATH = "src/images/";
	
	private Thread thread;
	private boolean serverOn;
	private ServerSocket server;
	private PostManager manager;
	private int count;

	public Server() throws IOException {
		count = 0;
		manager = new PostManager();
		server = new ServerSocket(3333);
		thread = new Thread(this);
		thread.start();
		serverOn = true;
		Logger.getGlobal().log(Level.INFO, "Server 3333: On");
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
				case ADD_POST:
					int size = input.readInt();
					addPost(connection, input.readUTF(), input.readNBytes(size), input.readUTF(), input.readInt());
					break;
				case CONTACT:
					Logger.getGlobal().log(Level.INFO, "New connection added to the connection list");
					break;
				case REQUEST_LIST:
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

	private void addPost(Socket connection, String tittle, byte[] photoPhat, String description, int phone) {
		manager.addPost(manager.createPost(tittle, processImage(photoPhat, String.valueOf(count++)), description, phone));
		Logger.getGlobal().log(Level.INFO, connection.getInetAddress() + "has added a new post");
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
	
	private void sendPostList(Socket connection, DataOutputStream output) throws IOException {
		output.writeInt(manager.getPostList().size());
		for (Post post : manager.getPostList()) {
			byte[] image = processImageToSend(post.getPhotoPath());
			output.writeInt(image.length);
			output.writeInt(post.getId());
			output.writeUTF(post.getTitle());
			output.write(image);
			output.writeUTF(post.getDescription());
			output.writeInt(post.getPhone());
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

	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
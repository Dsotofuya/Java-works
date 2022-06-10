package network.server;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import model.User;
import network.server.punto1.ServerServices;

public class ServerLive implements Runnable {

	private Thread thread;
	private boolean serverOn;
	private ServerSocket server;
	private ArrayList<ServerConnection> connections;
	private ArrayList<User> userList;
	private int count;
	
	public ServerLive() throws IOException {
		new ServerServices();
		connections = new ArrayList<>();
		userList = new ArrayList<>();
		count = 0;
		server = new ServerSocket(1111);
		thread = new Thread(this);
		thread.start();
		serverOn = true;
		Logger.getGlobal().log(Level.INFO, "Server on 1111...");
	}

	@Override
	public void run() {
		while (serverOn) {
			try {
				Socket connection = server.accept();
				Logger.getGlobal().log(Level.INFO, "New connection: " + connection.getInetAddress());
				connections.add(new ServerConnection(connection, this));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	public void addPost(Socket connection, String name, byte[] photoPhat, long number) {
		userList.add(new User(count++, name, processImage(photoPhat, String.valueOf(count++)), number));
		Logger.getGlobal().log(Level.INFO, connection.getInetAddress() + "has added a new post");
	}

	private String processImage(byte[] image, String name) {
		ByteArrayInputStream bis = new ByteArrayInputStream(image);
		BufferedImage bufferedImage;
		String path = "src/data/" + name + ".png";
		try {
			bufferedImage = ImageIO.read(bis);
			ImageIO.write(bufferedImage, "png", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public ArrayList<User> getUserList() {
		return userList;
	}

	public static void main(String[] args) {
		try {
			new ServerLive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

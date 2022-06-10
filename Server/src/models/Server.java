package models;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server implements Runnable{

	private ServerSocket serverSocket;
	private boolean serverOn;
	private Thread thread;
	
	public Server() {
		try {
			serverSocket = new ServerSocket(5000);
			serverOn = true;
			thread = new Thread(this);
			thread.start();
			Logger.getGlobal().info("Server init on port 5000");
			//init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init() throws IOException {
		Socket connection = serverSocket.accept();
		Logger.getGlobal().info("Connection acepted!");
		InputStream inputStream = connection.getInputStream();
		//Leemos el tamaño que es el primer byte
		int size = inputStream.read();
		byte[] textInBytes = new byte[size];
		for (int i = 0; i < size; i++) {
			textInBytes[i] = (byte) inputStream.read();
		}
		//Otra opcion para leer
		//inputStream.read(textInBytes);
		System.out.println(new String(textInBytes));
	}
	
	public static void main(String[] args) {
		new Server();
	}

	@Override
	public void run() {
		while (serverOn) {
			try {
				Socket connection = serverSocket.accept();
				Logger.getGlobal().info("Connection acepted!");
				DataInputStream inputStream = new DataInputStream(connection.getInputStream());
				System.out.println(inputStream.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
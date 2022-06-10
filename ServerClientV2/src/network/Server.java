package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable{

	private Thread thread;
	private boolean serverOn;
	private ServerSocket server;
	private ArrayList<Connection> connections;
	
	public Server() throws IOException {
		connections = new ArrayList<>();
		server = new ServerSocket(5000);
		thread = new Thread(this);
		thread.start();
		serverOn = true;
		Logger.getGlobal().log(Level.INFO, "Server on 5000...");
	}
	
	@Override
	public void run() {
		while (serverOn) {
			try {
				Socket connection = server.accept();
				Logger.getGlobal().log(Level.INFO, "New connection");
				connections.add(new Connection(connection));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
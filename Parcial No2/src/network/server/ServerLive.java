package network.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import network.Connection;

public class ServerLive implements Runnable {

	private Thread thread;
	private boolean serverOn;
	private ServerSocket server;
	private ArrayList<ServerConnection> connections;

	public ServerLive() throws IOException {
		connections = new ArrayList<>();
		server = new ServerSocket(2123);
		thread = new Thread(this);
		thread.start();
		serverOn = true;
		Logger.getGlobal().log(Level.INFO, "Server on 2123...");
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

	public void writeSeatList() {
		try (FileWriter writer = new FileWriter("report.txt"); BufferedWriter bw = new BufferedWriter(writer)) {
				bw.write("text");
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		try {
			new ServerLive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

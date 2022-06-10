package network.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable {

	private Thread thread;
	private boolean serverOn;
	private ServerSocket server;
	private ArrayList<Connection> connections;
	private int seats[][];
	private ArrayList<String> seatsReserveds;

	public Server() throws IOException {
		connections = new ArrayList<>();
		server = new ServerSocket(2123);
		thread = new Thread(this);
		thread.start();
		serverOn = true;
		initSeats();
		seatsReserveds = new ArrayList<String>();
		Logger.getGlobal().log(Level.INFO, "Server on 2123...");
	}

	@Override
	public void run() {
		while (serverOn) {
			try {
				Socket connection = server.accept();
				Logger.getGlobal().log(Level.INFO, "New connection: " + connection.getInetAddress());
				connections.add(new Connection(connection, this));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void initSeats() {
		seats = new int[10][10];
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats.length; j++) {
				seats[i][j] = new Random().nextInt(2);
			}
		}
	}

	public void addToWrite(String text) {
		seatsReserveds.add(text);
	}

	public void writeSeatList() {
		try (FileWriter writer = new FileWriter("report.txt"); BufferedWriter bw = new BufferedWriter(writer)) {
			for (String seat : seatsReserveds) {
				bw.write(seat);
			}
		} catch (IOException e) {
		}
	}

	public int[][] getSeats() {
		return seats;
	}

	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
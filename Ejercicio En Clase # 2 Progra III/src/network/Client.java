package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import control.IObserver;

public class Client implements Runnable {

	private static final String HOST = "localhost";
//	private static final String HOST = "10.4.74.191";
	private Socket socket;
	private DataInputStream input;
	private DataOutputStream output;
	private IObserver observer;
	private int[][] seats;

	public Client() throws UnknownHostException, IOException {
		socket = new Socket(HOST, 2123);
		input = new DataInputStream(socket.getInputStream());
		output = new DataOutputStream(socket.getOutputStream());
		seats = new int[10][10];
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (input.available() > 0) {
					processSeatsMatriz();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void processSeatsMatriz() throws IOException {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats.length; j++) {
				seats[i][j] = input.readInt();
			}
		}
		observer.updateSeats(seats, input.readUTF());
	}

	public void setObserver(IObserver observer) {
		this.observer = observer;
		new Thread(this).start();
	}

	public void requestSeat(int x, int y) {
		try {
		output.writeInt(x);
		output.writeInt(y);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
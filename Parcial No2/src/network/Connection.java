package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import model.IObserver;

public class Connection implements Runnable {

	private static final String HOST = "localhost";
//	private static final String HOST = "10.4.74.191";
	private Socket socket;
	private DataInputStream input;
	private DataOutputStream output;
	private IObserver observer;

	public Connection() throws UnknownHostException, IOException {
		socket = new Socket(HOST, 2123);
		input = new DataInputStream(socket.getInputStream());
		output = new DataOutputStream(socket.getOutputStream());
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (input.available() > 0) {
					observer.update();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void setObserver(IObserver observer) {
		this.observer = observer;
		new Thread(this).start();
	}

	public void request() {
		try {
		output.writeUTF("requuest");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

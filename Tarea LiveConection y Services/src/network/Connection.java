package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import model.IObserver;

public class Connection implements Runnable {

	private static final String HOST = "localhost";
	private Socket socket;
	private DataInputStream input;
	private DataOutputStream output;
	private IObserver observer;

	public Connection() throws UnknownHostException, IOException {
		socket = new Socket(HOST, 1111);
		input = new DataInputStream(socket.getInputStream());
		output = new DataOutputStream(socket.getOutputStream());
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (input.available() > 0) {
					observer.updateState(input.readUTF());
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

	public void register(String name, byte[] image, int number) {
		try {
			output.writeUTF(name);
			output.writeInt(image.length);
			output.writeInt(number);
			output.write(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

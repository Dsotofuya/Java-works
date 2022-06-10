package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import control.IObserver;

public class Connection implements Runnable{

	private Socket socket;
	private DataInputStream input;
	private IObserver observer;

	private static final String HOST = "localhost";
//	private static final String HOST = "192.168.1.8";
	
	public Connection() throws UnknownHostException, IOException {
		socket = new Socket(HOST, 2323);
		input = new DataInputStream(socket.getInputStream());
	}

	@Override
	public void run() {
		while(true) {
			try {
				if (input.available() > 0) {
					Request res = Request.valueOf(input.readUTF());
					switch (res) {
					case NOTIFY:
						notifyUser();
						break;
					default:
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void notifyUser() throws IOException {
			String data = input.readUTF();
			observer.update(data);
	}

	public void setObserver(IObserver observer) {
		this.observer = observer;
		new Thread(this).start();
	}
}

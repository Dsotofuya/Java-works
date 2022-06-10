package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection implements Runnable{

	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;
	private Thread thread;

	public Connection(Socket socket) throws UnknownHostException, IOException {
		this.socket = socket;
		output = new DataOutputStream(this.socket.getOutputStream());
		input = new DataInputStream(this.socket.getInputStream());
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while(true) {
			try {
				if (input.available() > 0) {
					Requests req = Requests.valueOf(input.readUTF());
					switch (req) {
					case GET_TEXT:
						output.writeUTF("Hola");
						break;
					case SEND_TEXT:
						System.out.println(input.readUTF());
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
}

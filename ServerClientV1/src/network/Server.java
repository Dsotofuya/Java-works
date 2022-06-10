package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable{

	private Thread thread;
	private boolean serverOn;
	private ServerSocket server;
	
	public Server() throws IOException {
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
				DataInputStream input = new DataInputStream(connection.getInputStream());
				Requests req = Requests.valueOf(input.readUTF());
				switch (req) {
				case GET_TEXT:
					DataOutputStream output = new DataOutputStream(connection.getOutputStream());
					output.writeUTF("Server response");
					break;
				case SEND_TEXT:
					System.out.println(input.readUTF());
					break;
				default:
					break;
				}
			
				
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
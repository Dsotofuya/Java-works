package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {

	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;
	private Server server;
	private int id;

	public Connection(int id, Socket socket, Server server) throws UnknownHostException, IOException {
		this.id = id;
		this.server = server;
		this.socket = socket;
		output = new DataOutputStream(this.socket.getOutputStream());
		input = new DataInputStream(this.socket.getInputStream());
//		thread = new Thread(this);
//		thread.start();
	}
	
	public void enviaMensaje(String mensaje){
		try {
			output.writeUTF(mensaje);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

//	@Override
//	public void run() {
//		//		while (true) {
//		try {
//			server.sendNotification("aaa", server.findConnection(id));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public int getId() {
		return id;
	}

	public Socket getSocket() {
		return socket;
	}
}

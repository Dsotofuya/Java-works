package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {

	private Socket socket;
	private ServerLive server;
	private int id;

	public Connection(int id, Socket socket, ServerLive serverLive) throws UnknownHostException, IOException {
		this.id = id;
		this.socket = socket;
		this.server = serverLive;
	}

	public void sendMessage(int id, String message) throws IOException {
		Socket destinatary = server.findConnection(id);
		DataOutputStream dataOutput = new DataOutputStream(destinatary.getOutputStream());
		dataOutput.writeUTF(Request.NOTIFY.toString());
		dataOutput.writeUTF(message);
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public int getId() {
		return id;
	}
}

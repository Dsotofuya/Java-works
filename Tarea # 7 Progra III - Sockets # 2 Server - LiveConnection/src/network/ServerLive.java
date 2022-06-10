package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerLive implements Runnable {

	private ArrayList<Connection> connections;
	private Thread thread;
	private DataInputStream input;
	private boolean serverOn;
	private ServerSocket server;
	private int count;

	public ServerLive() {
		try {
			count = 0;
			connections = new ArrayList<>();
			server = new ServerSocket(2323);
			thread = new Thread(this);
			thread.start();
			serverOn = true;
			Logger.getGlobal().log(Level.INFO, "Server 2323: On");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (serverOn) {
			try {
				Socket connection = server.accept();
				Logger.getGlobal().log(Level.INFO, "New connection: " + connection.getInetAddress().getHostName());
				input = new DataInputStream(connection.getInputStream());
				String a = input.readUTF();
				System.out.println(a);
				Request req = Request.valueOf(a);
				switch (req) {
				case CONTACT:
					System.out.println("----------------------------------");
					int destinaraty = input.readInt();
					System.out.println(destinaraty);
					String message = input.readUTF();
					Connection newConnection = new Connection(count++, connection, this) ;
					Logger.getGlobal().log(Level.INFO, "New connection added to the connection list with id: " + count);
					connections.add(newConnection);
					newConnection.sendMessage(destinaraty, message);
					System.out.println(destinaraty + message);
					break;
				default:
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Socket findConnection(int id) {
		Connection auxConnection = null;
		for (Connection connection : connections) {
			if (id == connection.getId()) {
				auxConnection = connection;
			}
		}
		return auxConnection.getSocket();
	}
}

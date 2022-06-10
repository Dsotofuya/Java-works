package network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import model.User;

public class ServerConnection implements Runnable {

	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;
	private Thread thread;
	private ServerLive server;

	public ServerConnection(Socket socket, ServerLive server) throws UnknownHostException, IOException {
		this.server = server;
		this.socket = socket;
		output = new DataOutputStream(this.socket.getOutputStream());
		input = new DataInputStream(socket.getInputStream());
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (input.available() > 0) {
					String name = input.readUTF();
					int lenght = input.readInt();
					int number = input.readInt();
					byte[] image = input.readNBytes(lenght);
					server.addPost(socket, name, image, number);
					System.out.println("Usuario añadido a la rifa");
					for (User b : server.getUserList()) {
						System.out.println(b.getName() +  b.getPhoto() +" - " +  b.getNumber() );
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void senInfo(String message) throws IOException {
		output.writeUTF(message);
	}
}

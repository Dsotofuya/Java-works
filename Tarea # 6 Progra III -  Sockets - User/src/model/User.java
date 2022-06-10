package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class User {

	private Socket socket;
	private DataOutputStream outputStream;
	private DataInputStream inputStream;
	
	public User() {
		initUser();
	}
	
	private void initUser() {
		try {
			socket = new Socket("localHost", 4444);
			outputStream = new DataOutputStream(socket.getOutputStream());
			inputStream = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String text) throws IOException {
			outputStream.writeUTF(text);
			outputStream.flush();
	}
	
	public String read() throws IOException {
		return inputStream.readUTF();
	}
}

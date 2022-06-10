package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;

	public Client() throws UnknownHostException, IOException {
		 socket = new Socket("localhost", 5000);
		 output = new DataOutputStream(socket.getOutputStream());
		 input = new DataInputStream(socket.getInputStream());
	}
	
	public void sendInfo() {
		try {
			output.writeUTF(Requests.SEND_TEXT.toString());
			output.writeUTF("Hola");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void requestInfo() throws UnknownHostException, IOException {
		output.writeUTF(Requests.GET_TEXT.toString());
		System.out.println(input.readUTF());
	}
	
	public static void main(String[] args) {
		try {
			new Client();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

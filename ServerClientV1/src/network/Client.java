package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public void sendInfo() throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 5000);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeUTF(Requests.SEND_TEXT.toString());
		output.writeUTF("Hola");
		socket.close();
	}

	public void requestInfo() throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 5000);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeUTF(Requests.GET_TEXT.toString());
		DataInputStream inputStream = new DataInputStream(socket.getInputStream());
		System.out.println(inputStream.readUTF());
		socket.close();
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		try {
			client.sendInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package models;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	private Socket socket;
	private OutputStream outputStream;
	
	public Client() {
		try {
			socket = new Socket("localhost", 5000);
			outputStream = socket.getOutputStream();
			String text = "Hola";
			// Se envia el tamaño del texto(maximo puede  ser 127)
			outputStream.write(text.length());
			//Aca se envia el texto
			byte[] textInBytes = text.getBytes();
			outputStream.write(textInBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Client(int type) {
		try {
			socket = new Socket("localhost", 5000);
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataOutputStream.writeUTF("hola");
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Client(1);
	}
}

package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

public class Server implements Runnable {

	private ServerSocket serverSocket;
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	private AtomicReference<String> text;
	private boolean serverOn;
	private Thread thread;
	private String auxText;

	public Server() {
		try {
			auxText = "";
			text = new AtomicReference<String>();
			serverSocket = new ServerSocket(4444);
			serverOn = true;
			thread = new Thread(this);
			thread.start();
			Logger.getGlobal().info("Server 4444: On");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (serverOn) {
			try {
				Socket connection = serverSocket.accept();
				Logger.getGlobal().info(connection.getPort() + " - Connection acepted!");
				inputStream = new DataInputStream(connection.getInputStream());
				outputStream = new DataOutputStream(connection.getOutputStream());
				auxText = auxText + " " + inputStream.readUTF() ;
				Logger.getGlobal().info(connection.getPort() + " - has written: " + auxText);
				text.set(auxText);
				outputStream.writeUTF(text.get());
				outputStream.flush();
				System.out.println(text.get());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Server();
	}
}

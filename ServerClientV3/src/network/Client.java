package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import models.IObserver;
import models.Product;

public class Client implements Runnable{

	private Socket socket;
	private DataInputStream input;
	private IObserver observer;

	public Client() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 5000);
		input = new DataInputStream(socket.getInputStream());
	}

	@Override
	public void run() {
		while(true) {
			try {
				if (input.available() > 0) {
					Responses res = Responses.valueOf(input.readUTF());
					switch (res) {
					case INFO:
						processTime();
						break;
					default:
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void processTime() throws IOException {
		try {
			String data = input.readUTF();
			JSONParser parser = new JSONParser();
			JSONObject timeJson = (JSONObject) parser.parse(data);
			Product product = new Product(
					(String)timeJson.get("server"),
					(Long)timeJson.get("hour"));
			observer.updateTime(product);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void setObserver(IObserver observer) {
		this.observer = observer;
		new Thread(this).start();
	}
}
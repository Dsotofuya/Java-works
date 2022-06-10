package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import model.Post;

public class Conection {

	private Thread thread;
	Socket socket;
	DataInputStream inputStream;
	private DataOutputStream output;

	public Conection() throws UnknownHostException, IOException {
//		socket = new Socket("localhost", 3333);
//		inputStream = new DataInputStream(socket.getInputStream());
//		output = new DataOutputStream(socket.getOutputStream());
		notifyUser();
	}

	public void notifyUser() throws IOException {
		Socket socket = new Socket("localhost", 3333);
		inputStream = new DataInputStream(socket.getInputStream());
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						System.out.println("inicio");
						if (inputStream.available()>0) {
							String data = inputStream.readUTF();
							System.out.println(data);
//						switch (Request.valueOf(inputStream.readUTF())) {
//						case NOTIFY:
//							System.out.println(inputStream.readUTF());
//							break;
//						default:
//							break;
//						}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	public void addPost(String tittle, String photoPhat, String description, int phone)
			throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 3333);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeUTF(Request.ADD_POST.toString());
		output.writeUTF(tittle);
		output.writeUTF(photoPhat);
		output.writeUTF(description);
		output.writeInt(phone);
		socket.close();
	}

	public void contact(String idToConect) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 3333);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeUTF(Request.CONTACT.toString());
		output.writeUTF(idToConect);
		socket.close();
	}

	public ArrayList<Post> requestList() throws UnknownHostException, IOException {
		ArrayList<Post> auxList = new ArrayList<Post>();
		Socket socket = new Socket("localhost", 3333);
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		output.writeUTF(Request.REQUEST_LIST.toString());
		DataInputStream inputStream = new DataInputStream(socket.getInputStream());
		int xd = inputStream.readInt();
		for (int i = 0; i < xd; i++) {
			auxList.add(new Post(inputStream.readInt(), inputStream.readUTF(), inputStream.readUTF(),
					inputStream.readUTF(), inputStream.readInt()));
		}
		socket.close();
		return auxList;
	}
}

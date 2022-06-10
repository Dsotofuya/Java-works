package network;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import model.entity.Publicacion;

public class Client {

	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;
	
	public Client() throws UnknownHostException, IOException {
		 socket = new Socket("localhost", 5000);
		 output = new DataOutputStream(socket.getOutputStream());
		 input = new DataInputStream(socket.getInputStream());
	}
	
	public void sendInfo(String [] datos) {
		try {
			output.writeUTF(Requests.SEND_TEXT.toString());
			for (int i = 0; i < datos.length; i++) {
				output.writeUTF(datos[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(int id , String txt) {
		try {
			output.writeUTF(Requests.RECIVE_TEXT.toString());
			output.writeInt(id);
			output.writeUTF(txt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Publicacion> requestInfo() throws UnknownHostException, IOException {
		ArrayList< Publicacion > lista = new ArrayList<>();
		output.writeUTF(Requests.GET_TEXT.toString());
		int size = input.readInt();
		for (int i = 0; i < size ; i++) {
			String title = input.readUTF();
			String description = input.readUTF();
			String phone  = input.readUTF();
			int sizeImg = input.readInt();
			byte[] textInBytes = new byte[sizeImg];
			for (int j = 0; j < sizeImg; j++) {
				textInBytes[j] = (byte) input.read();
			}
			createImg(textInBytes, phone+title);
			lista.add(new Publicacion(title, description, phone, "img/"+phone+title));
		}
		return lista;
	}
	
	public void createImg(byte[] img , String name) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(img);
	    BufferedImage bImage2 = ImageIO.read(bis);
	    ImageIO.write(bImage2, "jpg", new File("img/"+name));
	}
}

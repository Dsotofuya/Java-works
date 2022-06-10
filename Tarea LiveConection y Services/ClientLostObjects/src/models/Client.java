package models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.google.gson.Gson;


public class Client {

	private static final String LOCALHOST = "192.168.137.203";
	private static Socket socket;
	private String txt = "";
	private PostList postList;
	
	public void sendText(String text) throws IOException {
		try {
			socket = new Socket(LOCALHOST, 5000);
		} catch (IOException e) {		
			e.printStackTrace();
		}
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
 		dataOutputStream.writeUTF("Escribir");
 		dataOutputStream.writeUTF(text);
		socket.close();
	}
	
	public void sendDataToServer(String title, String description, String contactNumber, String image) throws IOException {
		
		
		try {
			socket = new Socket(LOCALHOST, 5000);
		} catch (IOException e) {		
			e.printStackTrace();
		}
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
 		dataOutputStream.writeUTF("Escribir");
		
		Post post = new Post(title, description, Integer.parseInt(contactNumber), image);
		
		dataOutputStream.writeUTF(new Gson().toJson(post));
		System.out.println(new Gson().toJson(post));
		socket.close();
	}

	
	public String encoder(String imagePath) {
		  String base64Image = "";
		  File file = new File(imagePath);
		  try (FileInputStream imageInFile = new FileInputStream(file)) {
		    byte imageData[] = new byte[(int) file.length()];
		    imageInFile.read(imageData);
		    base64Image = Base64.getEncoder().encodeToString(imageData);
		  } catch (FileNotFoundException e) {
		    System.out.println("Image not found" + e);
		  } catch (IOException ioe) {
		    System.out.println("Exception while reading the Image " + ioe);
		  }
		  return base64Image;
	}
	
	public static void decoder(String base64Image, String pathFile) {
		  try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
		    byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
		    imageOutFile.write(imageByteArray);
		  } catch (FileNotFoundException e) {
		    System.out.println("Image not found" + e);
		  } catch (IOException ioe) {
		    System.out.println("Exception while reading the Image " + ioe);
		  }
	}

	public void sendAndReceive() {
		
		postList = new PostList();
			try {
				socket = new Socket(LOCALHOST, 5000);
				DataOutputStream dataOutputStream;
				dataOutputStream = new DataOutputStream(socket.getOutputStream());
				dataOutputStream.writeUTF("Refrescar");
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				int size = dataInputStream.readInt();
				for (int i = 0; i < size ; i++) {
					Post post = new Gson().fromJson(dataInputStream.readUTF(), Post.class);
					int sizeImg = dataInputStream.readInt();
					byte[] textInBytes = new byte[sizeImg];
					for (int j = 0; j < sizeImg; j++) {
						textInBytes[j] = (byte) dataInputStream.read();
					}
					post.setImage("img/" + (post.getId()+post.getTitle()));
					createImg(textInBytes, post.getId()+post.getTitle());
					postList.add(post);
				}
				dataOutputStream.close();
				dataInputStream.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


	public void receiveText() throws IOException {
		try {
			socket = new Socket(LOCALHOST, 5000);
		} catch (IOException e) {		
			e.printStackTrace();
		}
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		dataOutputStream.writeUTF("Enviar");
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		
		try {
			txt = dataInputStream.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		socket.close();
	}
	
	public void receivePost() throws IOException {
		try {
			socket = new Socket(LOCALHOST, 5000);
		} catch (IOException e) {		
			e.printStackTrace();
		}
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		dataOutputStream.writeUTF("Recibir");
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		
		try {
			txt = dataInputStream.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		socket.close();
	}
	
	
	public void createImg(byte[] img , String name) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(img);
	    BufferedImage bImage2 = ImageIO.read(bis);
	    ImageIO.write(bImage2, "jpg", new File("img/"+name));
	}
	
	public String getTxt() {
		return txt;
	}
	
	public PostList getPostList() {
		return postList;
	}
}

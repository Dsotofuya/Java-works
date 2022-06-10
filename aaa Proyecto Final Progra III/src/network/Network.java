package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.Socket;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import model.NodeFolder;
import model.State;
import model.Tree;
import model.Type;

public class Network {

	private String host = "localhost";

	public boolean login(String user, String password) {
		boolean aux = false;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.LOGIN.toString());
			output.writeUTF(user);
			output.writeUTF(password);
			aux = input.readBoolean();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aux;
	}

	public boolean register(String user, String password) {
		boolean aux = false;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.REGISTER.toString());
			output.writeUTF(user);
			output.writeUTF(password);
			aux = input.readBoolean();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aux;
	}

	public Tree getTreePostal(String user) {
		Tree tree = null;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.GET_TREE_POSTAL_TO_USER.toString());
			output.writeUTF(user);
			String xml = input.readUTF();
			tree = getTree(convertStringToXMLDocument(xml));
			socket.close();
		} catch (Exception e) {
		}
		return tree;
	}

	public static Tree getTree(Document documento) {
		Tree tree = new Tree();
		Element element = documento.getRootElement();
		Element folders = element.getChild("NODE_FOLDER");
		NodeFolder root = new NodeFolder(folders.getChildText("NAME"), State.valueOf(folders.getChildText("STATE")),
				Type.valueOf(folders.getChildText("TYPE")));
		tree.setRoot(root);
		for (Element folder : folders.getChildren("NODE_FOLDER")) {
			tree.addNewFolder(folder.getChildText("NAME"), State.valueOf(folder.getChildText("STATE")));
			for (Element postal : folder.getChildren("NODE_POSTAL")) {
				tree.addNewPostal(folder.getChildText("NAME"), postal.getChildText("NAME"), State.valueOf(folder.getChildText("STATE")));
				for (Element leaf : postal.getChildren("NODE_TEXT")) {
					tree.addNewLeaf(postal.getChildText("NAME"), leaf.getChildText("NAME"), leaf.getChildText("DATA"),
							Type.valueOf(leaf.getChildText("TYPE")), State.valueOf(folder.getChildText("STATE")));
				}
				for (Element leaf : postal.getChildren("NODE_IMAGE")) {
					tree.addNewLeaf(postal.getChildText("NAME"), leaf.getChildText("NAME"), leaf.getChildText("DATA"),
							Type.valueOf(leaf.getChildText("TYPE")), State.valueOf(folder.getChildText("STATE")));
				}
			}
			processfolders(tree, folder);
		}
		return tree;
	}

	private static void processfolders(Tree tree, Element folder) {
		for (Element folderInside : folder.getChildren("NODE_FOLDER")) {
			tree.addNewFolderInsideOtherFolder(folder.getChildText("NAME"), folderInside.getChildText("NAME"), State.valueOf(folder.getChildText("STATE")));
			for (Element postal : folderInside.getChildren("NODE_POSTAL")) {
				tree.addNewPostal(folderInside.getChildText("NAME"), postal.getChildText("NAME"), State.valueOf(folder.getChildText("STATE")));
				for (Element leaf : postal.getChildren("NODE_TEXT")) {
					tree.addNewLeaf(postal.getChildText("NAME"), leaf.getChildText("NAME"), leaf.getChildText("DATA"),
							Type.valueOf(leaf.getChildText("TYPE")), State.valueOf(folder.getChildText("STATE")));
				}
				for (Element leaf : postal.getChildren("NODE_IMAGE")) {
					tree.addNewLeaf(postal.getChildText("NAME"), leaf.getChildText("NAME"), leaf.getChildText("DATA"),
							Type.valueOf(leaf.getChildText("TYPE")), State.valueOf(folder.getChildText("STATE")));
				}
			}
			processfolders(tree, folderInside);
		}
	}

	private static Document convertStringToXMLDocument(String xmlString) {
		SAXBuilder builder = new SAXBuilder();
		Document document = null;
		try {
			document = builder.build(new StringReader(xmlString));
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		return document;
	}

	public void addFolder(/* String user, */ String folderName) {
//		boolean response = false;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.ADD_FOLDER.toString());
//			output.writeUTF(user);
			output.writeUTF(folderName);
//			response = input.readBoolean();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return response;
	}

	public void addFolderInsideOtheFolder(/* String user, */ String folderToAdd, String name) {
//		boolean response = false;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.ADD_FOLDER_INSIDE_OTHER.toString());
//			output.writeUTF(user);
			output.writeUTF(folderToAdd);
			output.writeUTF(name);
//			response = input.readBoolean();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return response;
	}

	public void addPostal(/* String user, */ String folder, String postal) {
//		boolean response = false;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.ADD_POSTAL.toString());
//			output.writeUTF(user);
			output.writeUTF(folder);
			output.writeUTF(postal);
//			response = input.readBoolean();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return response;
	}

	public void addImage(/* String user, */ String postal, String name, byte[] image) {
//		boolean response = false;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.ADD_IMAGE.toString());
//			output.writeUTF(user);
			output.writeUTF(postal);
			output.writeUTF(name);
			output.writeInt(image.length);
			output.write(image);
//			response = input.readBoolean();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return response;
	}

	public void addText(/* String user, */ String postal, String name, String text) {
//		boolean response = false;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.ADD_TEXT.toString());
//			output.writeUTF(user);
			output.writeUTF(postal);
			output.writeUTF(name);
			output.writeUTF(text);
//			response = input.readBoolean();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return response;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void edit(/* String user, */ String archive, String newName) {
//		boolean response = false;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.EDIT.toString());
//			output.writeUTF(user);
			output.writeUTF(archive);
			output.writeUTF(newName);
//			response = input.readBoolean();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return response;
	}
	

	public void editImage(String imageName, byte[] image) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.EDIT_IMAGE.toString());
//			output.writeUTF(user);
			output.writeUTF(imageName);
			output.writeInt(image.length);
			output.write(image);
//			response = input.readBoolean();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void editText(String textName, String newText) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.EDIT_TEXT.toString());
//			output.writeUTF(user);
			output.writeUTF(textName);
			output.writeUTF(newText);
//			response = input.readBoolean();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String object) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
//			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.DELETE.toString());
//			output.writeUTF(user);
			output.writeUTF(object);
//			response = input.readBoolean();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public byte[] getImage(String imageSelected) {
		byte[] image = null;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.GET_IMAGE.toString());
			output.writeUTF(imageSelected);
			int length = input.readInt();
			image = input.readNBytes(length);
			socket.close();
		} catch (Exception e) {
		}
		return image;
	}

	public String getTextPostal(String name) {
		String text = null;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.GET_TEXT.toString());
			output.writeUTF(name);
			text = input.readUTF();
			socket.close();
		} catch (Exception e) {
		}
		return text;
	}
}

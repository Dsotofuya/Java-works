package network;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import model.UserManager;
import model.postalTree.INode;
import model.postalTree.TreePostal;
import model.postalTree.Type;
import model.userTree.ANode;
import model.userTree.State;
import model.userTree.TreeUser;

public class Server implements Runnable {

	private Thread thread;
	private boolean serverOn;
	private ServerSocket server;
	private UserManager manager;

	public Server() throws IOException {
		manager = new UserManager();
		server = new ServerSocket(1234);
		thread = new Thread(this);
		thread.start();
		serverOn = true;
		Logger.getGlobal().log(Level.INFO, "Server 1234: On");
	}

	@Override
	public void run() {
		while (serverOn) {
			try {
				Socket connection = server.accept();
				Logger.getGlobal().log(Level.INFO, "New connection: " + connection.getInetAddress().getHostName());
				DataInputStream input = new DataInputStream(connection.getInputStream());
				DataOutputStream output = new DataOutputStream(connection.getOutputStream());
				Request req = Request.valueOf(input.readUTF());
				switch (req) {
				case ADD_FOLDER:
					addFolder(input, output);
					break;
				case ADD_FOLDER_INSIDE_OTHER:
					addNewFolderInsideOtherFolder(input, output);
					break;
				case ADD_IMAGE:
					addImage(input, output);
					break;
				case ADD_POSTAL:
					addPostal(input, output);
					break;
				case ADD_TEXT:
					addText(input, output);
					break;
				case EDIT:
					edit(input, output);
					break;
				case EDIT_IMAGE:
					editImage(input, output);
					break;
				case EDIT_TEXT:
					editText(input, output);
					break;
				case DELETE:
					delete(input, output);
					break;
				case LOGIN:
					loginUser(input, output);
					break;
				case REGISTER:
					registerUser(input, output);
					break;
				case GET_TREE_POSTAL_TO_USER:
					sendPostalTreeToUser(input, output);
					break;
				case GET_TREE_POSTAL:
					sendPostalTree(input, output);
					break;
				case GET_TREE_USER:
					sendUserTree(output);
					break;
				case GET_IMAGE:
					sendImage(input, output);
					break;
				case GET_TEXT:
					sendText(input, output);
					break;
				case CHANGE_PASSWORD:
					changePassword(input, output);
					break;
				case CONCEDE_PRIVILEGE:
					concedePrivilege(input, output);
					break;
				default:
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void concedePrivilege(DataInputStream input, DataOutputStream output) {
		try {
			String user = input.readUTF();
			String archive = input.readUTF();
			State privilege = State.valueOf(input.readUTF());
			manager.concedePrivilege(user, archive, privilege);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void changePassword(DataInputStream input, DataOutputStream output) {
		try {
			String name = input.readUTF();
			manager.getUsers().search(name).setData(input.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void sendText(DataInputStream input, DataOutputStream output) {
		try {
			String name = input.readUTF();
			output.writeUTF(manager.getTreeGeneral().search(name).getData());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void sendImage(DataInputStream input, DataOutputStream output) {
		try {
			String name = input.readUTF();
			byte[] image = processImageToSend(manager.getTreeGeneral().search(name).getData());
			output.writeInt(image.length);
			output.write(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void editImage(DataInputStream input, DataOutputStream output) {
		try {
			String name = input.readUTF();
			int length = input.readInt();
			byte[] image = input.readNBytes(length);
			String path = processImage(image, name);
			manager.getTreeGeneral().search(name).edit(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void editText(DataInputStream input, DataOutputStream output) {
		try {
			manager.getTreeGeneral().search(input.readUTF()).edit(input.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void delete(DataInputStream input, DataOutputStream output) {
		try {
			String objetc = input.readUTF();
			INode node = manager.getTreeGeneral().search(objetc);
			INode dad = manager.getTreeGeneral().searchDad(node);
			dad.removeChild(node);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void edit(DataInputStream input, DataOutputStream output) {
		try {
			manager.getTreeGeneral().search(input.readUTF()).rename(input.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addText(DataInputStream input, DataOutputStream output) {
		try {
			manager.getTreeGeneral().addNewLeaf(input.readUTF(), input.readUTF(), input.readUTF(), Type.TEXT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addImage(DataInputStream input, DataOutputStream output) {
		try {
			String postal = input.readUTF();
			String name = input.readUTF();
			int length = input.readInt();
			byte[] image = input.readNBytes(length);
			String path = processImage(image, name);
			manager.getTreeGeneral().addNewLeaf(postal, name, path, Type.IMAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String processImage(byte[] image, String name) {
		ByteArrayInputStream bis = new ByteArrayInputStream(image);
		BufferedImage bufferedImage;
		String path = "src/img/" + name + ".png";
		try {
			bufferedImage = ImageIO.read(bis);
			ImageIO.write(bufferedImage, "png", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	private void addPostal(DataInputStream input, DataOutputStream output) {
		try {
			manager.getTreeGeneral().addNewPostal(input.readUTF(), input.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addNewFolderInsideOtherFolder(DataInputStream input, DataOutputStream output) {
		try {
			manager.getTreeGeneral().addNewFolderInsideOtherFolder(input.readUTF(), input.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addFolder(DataInputStream input, DataOutputStream output) {
		try {
			manager.getTreeGeneral().addNewFolder(input.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void registerUser(DataInputStream input, DataOutputStream output) throws IOException {
		boolean xd = manager.addUser(input.readUTF(), input.readUTF());
		if (xd) {
			Logger.getGlobal().log(Level.INFO, "User susefully registred");
		} else {
			Logger.getGlobal().log(Level.INFO, "User alreade taked, F");
		}
		output.writeBoolean(xd);
	}

	private void loginUser(DataInputStream input, DataOutputStream output) throws IOException {
		Logger.getGlobal().log(Level.INFO, "User login request");
		output.writeBoolean(manager.login(input.readUTF(), input.readUTF()));
	}

	public void sendPostalTree(DataInputStream input, DataOutputStream output) {
		try {
			File file = generateTreePostal(manager.getTreeGeneral());
			Reader fileReader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(fileReader);
			StringBuilder sb = new StringBuilder();
			String line = bufReader.readLine();
			while (line != null) {
				sb.append(line).append("\n");
				line = bufReader.readLine();
			}
			bufReader.close();
			String treeXml = sb.toString();
			output.writeUTF(treeXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendPostalTreeToUser(DataInputStream input, DataOutputStream output) {
		try {
			File file = generateTreePostal(manager.listArchives(input.readUTF()));
			Reader fileReader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(fileReader);
			StringBuilder sb = new StringBuilder();
			String line = bufReader.readLine();
			while (line != null) {
				sb.append(line).append("\n");
				line = bufReader.readLine();
			}
			bufReader.close();
			String treeXml = sb.toString();
			output.writeUTF(treeXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static File generateTreePostal(TreePostal tree) throws Exception {
		File fileTemep = File.createTempFile("archivoXml", null);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation implementation = builder.getDOMImplementation();
		Document document = implementation.createDocument(null, "POSTAL_TREE", null);
		document.setXmlVersion("1.0");
		Element root = document.getDocumentElement();
		Element itemNode = document.createElement("TREE_POSTAL");
		root.appendChild(createINode(tree.getRoot(), document, itemNode));
		Source source = new DOMSource(document);
		Result result = new StreamResult(fileTemep);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(source, result);
		return fileTemep;
	}

	private static Element createINode(INode node, Document document, Element dad) {
		Element valueNode = document.createElement("NODE_" + node.getType());
		Element name = document.createElement("NAME");
		Text valueName = document.createTextNode(node.getName());
		name.appendChild(valueName);
		Element state = document.createElement("STATE");
		Text valueState = document.createTextNode(node.getState().toString());
		state.appendChild(valueState);
		Element type = document.createElement("TYPE");
		Text valueType = document.createTextNode(node.getType().toString());
		type.appendChild(valueType);
		Element data = document.createElement("DATA");
		Text valueData = document.createTextNode(node.getData());
		data.appendChild(valueData);
		valueNode.appendChild(name);
		valueNode.appendChild(data);
		valueNode.appendChild(state);
		valueNode.appendChild(type);
		for (INode nodeU : node.getChildren()) {
			createINode(nodeU, document, valueNode);
		}
		dad.appendChild(valueNode);
		return valueNode;
	}

	public void sendUserTree(DataOutputStream output) {
		try {
			File file = generateTreeUser(manager.getUsers());
			Reader fileReader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(fileReader);
			StringBuilder sb = new StringBuilder();
			String line = bufReader.readLine();
			while (line != null) {
				sb.append(line).append("\n");
				line = bufReader.readLine();
			}
			bufReader.close();
			String treeXml = sb.toString();
			output.writeUTF(treeXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static File generateTreeUser(TreeUser tree) throws Exception {
		File fileTemep = File.createTempFile("archivoXml", null);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation implementation = builder.getDOMImplementation();
		Document document = implementation.createDocument(null, "USER_TREE", null);
		document.setXmlVersion("1.0");
		Element root = document.getDocumentElement();
		Element itemNode = document.createElement("TREE_USER");
		root.appendChild(createANode(tree.getRoot(), document, itemNode));
		Source source = new DOMSource(document);
		Result result = new StreamResult(fileTemep);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(source, result);
		return fileTemep;
	}

	private static Element createANode(ANode node, Document document, Element dad) {
		Element valueNode = document.createElement("NODE_" + node.getType());
		Element name = document.createElement("NAME");
		Text valueName = document.createTextNode(node.getName());
		name.appendChild(valueName);
		Element type = document.createElement("TYPE");
		Text valueType = document.createTextNode(node.getType().toString());
		type.appendChild(valueType);
		Element data = document.createElement("DATA");
		Text valueData = document.createTextNode(node.getData());
		data.appendChild(valueData);
		valueNode.appendChild(name);
		valueNode.appendChild(data);
		valueNode.appendChild(type);
		for (ANode nodeU : node.getChildren()) {
			createANode(nodeU, document, valueNode);
		}
		dad.appendChild(valueNode);
		return valueNode;
	}

	private byte[] processImageToSend(String path) {
		byte[] image = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(ImageIO.read(new File(path)), "png", bos);
			image = bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
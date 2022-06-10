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
import model.userTree.NodeRoot;
import model.userTree.TreeUser;

public class Network {

	private String host = "localhost";

	public Tree getTreePostal() {
		Tree tree = null;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.GET_TREE_POSTAL.toString());
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
			tree.addNewFolder(folder.getChildText("NAME"));
			for (Element postal : folder.getChildren("NODE_POSTAL")) {
				tree.addNewPostal(folder.getChildText("NAME"), postal.getChildText("NAME"));
				for (Element leaf : postal.getChildren("NODE_TEXT")) {
					tree.addNewLeaf(postal.getChildText("NAME"), leaf.getChildText("NAME"), leaf.getChildText("DATA"),
							Type.valueOf(leaf.getChildText("TYPE")));
				}
				for (Element leaf : postal.getChildren("NODE_IMAGE")) {
					tree.addNewLeaf(postal.getChildText("NAME"), leaf.getChildText("NAME"), leaf.getChildText("DATA"),
							Type.valueOf(leaf.getChildText("TYPE")));
				}
			}
			processfolders(tree, folder);
		}
		return tree;
	}

	private static void processfolders(Tree tree, Element folder) {
		for (Element folderInside : folder.getChildren("NODE_FOLDER")) {
			tree.addNewFolderInsideOtherFolder(folder.getChildText("NAME"), folderInside.getChildText("NAME"));
			for (Element postal : folderInside.getChildren("NODE_POSTAL")) {
				tree.addNewPostal(folderInside.getChildText("NAME"), postal.getChildText("NAME"));
				for (Element leaf : postal.getChildren("NODE_TEXT")) {
					tree.addNewLeaf(postal.getChildText("NAME"), leaf.getChildText("NAME"), leaf.getChildText("DATA"),
							Type.valueOf(leaf.getChildText("TYPE")));
				}
				for (Element leaf : postal.getChildren("NODE_IMAGE")) {
					tree.addNewLeaf(postal.getChildText("NAME"), leaf.getChildText("NAME"), leaf.getChildText("DATA"),
							Type.valueOf(leaf.getChildText("TYPE")));
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

	public void addFolder(String folderName) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(Request.ADD_FOLDER.toString());
			output.writeUTF(folderName);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addFolderInsideOtheFolder(String folderToAdd, String name) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(Request.ADD_FOLDER_INSIDE_OTHER.toString());
			output.writeUTF(folderToAdd);
			output.writeUTF(name);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addPostal(String folder, String postal) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(Request.ADD_POSTAL.toString());
			output.writeUTF(folder);
			output.writeUTF(postal);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addImage(String postal, String name, byte[] image) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(Request.ADD_IMAGE.toString());
			output.writeUTF(postal);
			output.writeUTF(name);
			output.writeInt(image.length);
			output.write(image);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addText(String postal, String name, String text) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(Request.ADD_TEXT.toString());
			output.writeUTF(postal);
			output.writeUTF(name);
			output.writeUTF(text);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void edit(String archive, String newName) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(Request.EDIT.toString());
			output.writeUTF(archive);
			output.writeUTF(newName);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void editImage(String imageName, byte[] image) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(Request.EDIT_IMAGE.toString());
			output.writeUTF(imageName);
			output.writeInt(image.length);
			output.write(image);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void editText(String textName, String newText) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(Request.EDIT_TEXT.toString());
			output.writeUTF(textName);
			output.writeUTF(newText);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void delete(String object) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(Request.DELETE.toString());
			output.writeUTF(object);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TreeUser getTreeUsers() {
		TreeUser tree = null;
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			DataInputStream input = new DataInputStream(socket.getInputStream());
			output.writeUTF(Request.GET_TREE_USER.toString());
			String xml = input.readUTF();
			tree = getTreeUser(convertStringToXMLDocument(xml));
			socket.close();
		} catch (Exception e) {
		}
		return tree;
	}

	public static TreeUser getTreeUser(Document documento) {
		TreeUser tree = new TreeUser();
		Element element = documento.getRootElement();
		Element folders = element.getChild("NODE_ROOT");
		NodeRoot root = new NodeRoot(folders.getChildText("NAME"));
		tree.setRoot(root);
		for (Element user : folders.getChildren("NODE_USER")) {
			tree.addUser(user.getChildText("NAME"), user.getChildText("DATA"));
			for (Element folder : user.getChildren("NODE_FOLDER")) {
				if (folder.getChildText("NAME").equalsIgnoreCase(State.CREATE.toString())) {
					for (Element archive : folder.getChildren("NODE_ARCHIVE")) {
						tree.addArchive(tree.search(user.getChildText("NAME")), folder.getChildText("NAME"),
								archive.getChildText("NAME"));
					}
				}
				if (folder.getChildText("NAME").equalsIgnoreCase(State.EDIT.toString())) {
					for (Element archive : folder.getChildren("NODE_ARCHIVE")) {
						tree.addArchive(tree.search(user.getChildText("NAME")), folder.getChildText("NAME"),
								archive.getChildText("NAME"));
					}
				}
				if (folder.getChildText("NAME").equalsIgnoreCase(State.VIEW.toString())) {
					for (Element archive : folder.getChildren("NODE_ARCHIVE")) {
						tree.addArchive(tree.search(user.getChildText("NAME")), folder.getChildText("NAME"),
								archive.getChildText("NAME"));
					}
				}
				if (folder.getChildText("NAME").equalsIgnoreCase(State.ALL.toString())) {
					for (Element archive : folder.getChildren("NODE_ARCHIVE")) {
						tree.addArchive(tree.search(user.getChildText("NAME")), folder.getChildText("NAME"),
								archive.getChildText("NAME"));
					}
				}
			}
		}
		return tree;
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

	public void addUser(String user, String password) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(Request.REGISTER.toString());
			output.writeUTF(user);
			output.writeUTF(password);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void changePasswordUser(String user, String newPassword) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(Request.CHANGE_PASSWORD.toString());
			output.writeUTF(user);
			output.writeUTF(newPassword);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ConcedePrivileges(String user, String archive, String privilege) {
		try {
			Socket socket = new Socket(host, 1234);
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(Request.CONCEDE_PRIVILEGE.toString());
			output.writeUTF(user);
			output.writeUTF(archive);
			output.writeUTF(privilege);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

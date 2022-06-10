package model.postalTree;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class TreePostal {

	private static final String FOLDERS = "Folders";

	private NodeFolder root;

	public TreePostal() {
		root = new NodeFolder(FOLDERS, State.VIEW, Type.FOLDER);
	}

	public INode search(String name) {
		if (root.getName().equalsIgnoreCase(name)) {
			return root;
		}
		return search(root, name);
	}

	private INode search(INode node, String name) {
		if (!node.getChildren().isEmpty()) {
			for (INode actual : node.getChildren()) {
				if (actual.getName().equalsIgnoreCase(name)) {
					return actual;
				} else {
					INode search = search(actual, name);
					if (search != null) {
						return search;
					}
				}
			}
		}
		return null;
	}

	public INode searchDad(INode node) {
		for (int i = 0; i < root.getChildren().size(); i++) {
			if (root.search(node.getName())) {
				return root;
			}
		}
		return searchDad(root, node);
	}

	private INode searchDad(INode node, INode nodeChild) {
		if (!node.getChildren().isEmpty()) {
			for (INode actual : node.getChildren()) {
				if (actual.search(nodeChild.getName())) {
					return actual;
				} else {
					INode search = searchDad(actual, nodeChild);
					if (search != null) {
						return search;
					}
				}
			}
		}
		return null;
	}

	public void addNewFolder(String name) {
		root.add(name, null, State.VIEW, Type.FOLDER);
	}
	
	public void addNewFolderInsideOtherFolder(String folder, String name) {
		search(folder).add(name, null, State.VIEW, Type.FOLDER);
	}

	public void addNewPostal(String folder, String name) {
		search(folder).add(name, null, State.VIEW, Type.POSTAL);
	}

	public void addNewLeaf(String postal, String name, String data, Type type) {
		search(postal).add(name, data, State.VIEW, type);
	}

	public void delete(String name) {
		for (INode node : root.getChildren()) {
			for (INode nodeChild : node.getChildren()) {
				if (nodeChild.getData().equalsIgnoreCase(name)) {
					node.removeChild(nodeChild);
				}
				if (node.getChildren().size() == 0) {
					root.removeChild(node);
				}
			}
		}
	}

	public ArrayList<byte[]> getImagesInBytes(INode node, ArrayList<byte[]> images) {
		if (node.getType().equals(Type.IMAGE)) {
			images.add(processImageToSend(node.getData()));
		}
		if (node.getChildren() != null) {
			for (INode nodeChild : node.getChildren()) {
				getImagesInBytes(nodeChild, images);
			}
		}
		return images;
	}

	private byte[] processImageToSend(String path) {
		byte[] image = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(ImageIO.read(new File(path)), "jpg", bos);
			image = bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	public ArrayList<INode> path(INode node) {
		ArrayList<INode> path = new ArrayList<INode>();
		while (node != root) {
			node = searchDad(node);
			path.add(node);
		}
		return path;
	}

	public INode getRoot() {
		return root;
	}
	
	public void print() {
		print(root, "");
	}

	private void print(INode node, String level) {
		level += "  ";
		System.out.println(level + node.getName() + node.getState().toString());
		for (INode actual : node.getChildren()) {
			print(actual, level);
		}
	}
	
	
	public ArrayList<String> listTree(State state){
		return listTree(root, new ArrayList<String>(), state);
	}
	
	private ArrayList<String> listTree(INode node, ArrayList<String> list, State state){
		for (INode actual : node.getChildren()) {
			if (actual.getState().equals(state)) {
				list.add(actual.getName());
			}
		}
		return list;
	}

}
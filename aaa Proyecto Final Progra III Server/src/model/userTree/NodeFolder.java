package model.userTree;

import java.util.ArrayList;

public class NodeFolder implements ANode {

	private String name;
	private ArrayList<ANode> archives;

	public NodeFolder(String name) {
		this.name = name;
		archives = new ArrayList<ANode>();
	}

	@Override
	public void add(String name, String data) {
		archives.add(new NodeArchive(name));
	}

	@Override
	public void clear() {
		archives.clear();
	}

	@Override
	public void removeChild(ANode child) {
		archives.remove(child);
	}

	@Override
	public ArrayList<ANode> getChildren() {
		return archives;
	}

	@Override
	public boolean search(String name) {
		for (ANode aNode : archives) {
			if (name.equalsIgnoreCase(aNode.getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getData() {
		return null;
	}

	@Override
	public Type getType() {
		return Type.FOLDER;
	}

	@Override
	public void setData(String data) {
	}
}

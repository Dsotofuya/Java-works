package model.userTree;

import java.util.ArrayList;

public class NodeArchive implements ANode {

	private String name;
	private ArrayList<ANode> xd;

	public NodeArchive(String name) {
		this.name = name;
		xd = new ArrayList<ANode>();
	}

	@Override
	public void add(String name, String data) {
	}

	@Override
	public void clear() {
	}

	@Override
	public void removeChild(ANode child) {
	}

	@Override
	public ArrayList<ANode> getChildren() {
		return xd;
	}

	@Override
	public boolean search(String name) {
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
	public String getIcon() {
		return "src/data/img/archiveUser.png";
	}

	@Override
	public void setIcon(String path) {
	}

	@Override
	public Type getType() {
		return Type.ARCHIVE;
	}
}

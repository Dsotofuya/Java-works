package model.userTree;

import java.util.ArrayList;

public class UserNode implements ANode{

	private String name;
	private String password;
	private ArrayList<ANode> archives; 
	
	public UserNode(String name, String password) {
		this.name = name;
		this.password = password;
		archives = new ArrayList<ANode>();
		archives.add(new NodeFolder(State.CREATE.toString()));
		archives.add(new NodeFolder(State.EDIT.toString()));
		archives.add(new NodeFolder(State.VIEW.toString()));
		archives.add(new NodeFolder(State.ALL.toString()));
	}

	@Override
	public void add(String name, String data) {
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
	public String getData() {
		return password;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Type getType() {
		return Type.USER;
	}

	@Override
	public void setData(String data) {
		this.password = data;
	}
}
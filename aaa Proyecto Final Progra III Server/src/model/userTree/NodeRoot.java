package model.userTree;

import java.util.ArrayList;

public class NodeRoot implements ANode{

	private String name;
	private ArrayList<ANode> users;
	
	public NodeRoot(String name) {
		this.name = name;
		users = new ArrayList<ANode>();
	}

	@Override
	public void add(String name, String data) {
		users.add(new UserNode(name, data));
	}

	@Override
	public void clear() {
		users.clear();
	}

	@Override
	public void removeChild(ANode child) {
		users.remove(child);
	}

	@Override
	public ArrayList<ANode> getChildren() {
		return users;
	}

	@Override
	public boolean search(String name) {
		for (ANode aNode : users) {
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
		return Type.ROOT;
	}

	@Override
	public void setData(String data) {
	}
}

package models;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

public class NodeUser implements INode {
	private String id;
	private ArrayList<NodeUser> users;

	public NodeUser(String id) {
		users = new ArrayList<NodeUser>();
		this.id = id;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void addChild(INode node) {
		users.add((NodeUser) node);
	}

	@Override
	public ArrayList<INode> getChildren() {
		return new ArrayList<INode>(users);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public boolean searchChild(INode node) {
		for (INode actual : users) {
			if (actual.getId().equals(node.getId())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void removeChild(INode node) {
		users.remove(node);
	}

	@Override
	public String icon() {
		return "/img/user.png";
	}
}

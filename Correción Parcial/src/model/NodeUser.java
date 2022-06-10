package model;

import java.io.IOException;
import java.util.ArrayList;

public class NodeUser implements INode {

	private ArrayList<INode> childs;
	private String id;
	private String image;
	private boolean state;
	private String color;
	
	public NodeUser(String id) throws IOException {
		this.id = id;
		image = "src/img/user.png";
		this.childs = new ArrayList<>();
		state = true;
		color = "#ffffff";
	}

	public void addChild(INode child) {
		childs.add(child);
	}

	public void addChilds(ArrayList<INode> childs) {
		childs.addAll(childs);
	}

	public void removeChild(INode child) {
		childs.remove(child);
	}

	public ArrayList<INode> getChildren() {
		return new ArrayList<>(childs);
	}

	public void clear() {
		childs.clear();
	}

	@Override
	public String getIcon() {
		return image;
	}

	@Override
	public void add(String name) {
		try {
			childs.add(new NodeUser(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getData() {
		return id;
	}

	@Override
	public boolean search(String zone) {
		for (INode iNode : childs) {
			if (iNode.getData().equals(zone)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public double getTax() {
		return 0;
	}

	@Override
	public boolean getState() {
		return state;
	}

	@Override
	public void changeState() {
		state = false;
		color = "#7e808c";
	}

	@Override
	public void setColor(String hex) {
		this.color = hex;
	}

	@Override
	public String getColor() {
		return color;
	}
}
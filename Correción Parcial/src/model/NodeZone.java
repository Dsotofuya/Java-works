package model;

import java.io.IOException;
import java.util.ArrayList;

public class NodeZone implements INode {

	private String image;
	private String data;
	private ArrayList<INode> childs;
	private boolean state;
	private String color;
	
	public NodeZone(String data) throws IOException {
		image = "src/img/zone.png";
		this.data = data;
		childs = new ArrayList<INode>();
		state = true;
		color = "#ffffff";
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
		return childs;
	}

	public String getData() {
		return data;
	}
	
	@Override
	public void clear() {
		childs.clear();
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
		return 500;
	}

	@Override
	public boolean getState() {
		return state;
	}

	@Override
	public void changeState() {
		state = false;
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
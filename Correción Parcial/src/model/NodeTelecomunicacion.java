package model;

import java.io.IOException;
import java.util.ArrayList;

public class NodeTelecomunicacion implements INode {

	private String image;
	private String data;
	private ArrayList<INode> childs;
	private boolean state;
	private String color;

	public NodeTelecomunicacion(String data) throws IOException {
		image = "src/img/tele.png";
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
			childs.add(new NodeCompany(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<INode> getChilds() {
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
	public void removeChild(INode child) {
		childs.remove(child);
	}

	@Override
	public ArrayList<INode> getChildren() {
		return childs;
	}

	public INode search(INode node, String name) {
		if (!node.getChildren().isEmpty()) {
			for (INode actual : node.getChildren()) {
				if (actual.getData().equals(name)) {
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
		state =false;
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

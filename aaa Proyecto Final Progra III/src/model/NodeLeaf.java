package model;

import java.util.ArrayList;

public class NodeLeaf implements INode {

	private String icon;
	private String name;
	private String data;
	private State state;
	private Type type;
	private ArrayList<INode> childs;

	public NodeLeaf(String name, String data, State state, Type type) {
		childs = new ArrayList<INode>();
		this.name = name;
		this.data = data;
		this.state = state;
		this.type = type;
		if (type == Type.IMAGE) {
			icon = "src/data/img/image.png";
		}if (type == Type.TEXT) {
			icon = "src/data/img/text.png";
		}
	}

	@Override
	public String getData() {
		return data;
	}

	@Override
	public void clear() {
		data = "";
	}

	@Override
	public void removeChild(INode child) {
	}

	@Override
	public ArrayList<INode> getChildren() {
		return childs;
	}

	@Override
	public boolean search(String name) {
		return false;
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void add(String name, String data, State state, Type type) {
	}

	@Override
	public String getIcon() {
		return icon;
	}

	@Override
	public void rename(String name) {
		this.name = name;
	}

	@Override
	public void edit(String data) {
		this.data = data;
	}
}

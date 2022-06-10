package model.postalTree;

import java.util.ArrayList;

public class NodePostal implements INode {

	private String icon;
	private ArrayList<INode> childs;
	private String name;
	private State state;
	private Type type;

	public NodePostal(String name, State state, Type type) {
		childs = new ArrayList<INode>();
		this.name = name;
		this.state = state;
		this.type = type;
		icon = "src/data/img/postal.png";
	}

	@Override
	public void add(String name, String data, State state, Type type) {
		childs.add(new NodeLeaf(name, data, state, type));
	}

	@Override
	public String getData() {
		return null;
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

	@Override
	public boolean search(String name) {
		for (INode iNode : childs) {
			if (iNode.getData().equalsIgnoreCase(name)) {
				return true;
			}
		}
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
	public String getIcon() {
		return icon;
	}

	@Override
	public void rename(String name) {
		this.name = name;
	}

	@Override
	public void edit(String data) {
	}
	
	@Override
	public void setState(State state) {
		this.state = state;
	}
}

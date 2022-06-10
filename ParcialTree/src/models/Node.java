package models;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

public class Node implements INode {

	private String id;
	private ArrayList<INode> operadores;

	public Node(String id) {
		operadores = new ArrayList<INode>();
		this.id = id;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addChild(INode node) {
		operadores.add(node);
	}

	@Override
	public ArrayList<INode> getChildren() {
		return new ArrayList<INode>(operadores);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public boolean searchChild(INode node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeChild(INode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public String icon() {
		return "/img/root.png";
	}

}

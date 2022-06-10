package models;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

public class NodeEmpresa implements INode {

	private String id;
	private ArrayList<INode> zonas;

	public NodeEmpresa(String id) {
		System.out.println(id);
		this.id = id;
		zonas = new ArrayList<INode>();
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addChild(INode node) {
		zonas.add(node);
	}

	@Override
	public ArrayList<INode> getChildren() {
		return new ArrayList<INode>(zonas);
	}

	@Override
	public String getId() {
		System.out.println(id);
		return id;
	}

	@Override
	public boolean searchChild(INode node) {
		for (INode actual : zonas) {
			if (actual.getId().equals(node.getId())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void removeChild(INode node) {
		zonas.remove(node);
	}

	@Override
	public String icon() {
		return "/img/empresa.png";
	}

}

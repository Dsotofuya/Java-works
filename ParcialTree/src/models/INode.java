package models;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

public interface INode {

	public String getColor();

	public String icon();

	public void addChild(INode node);

	public ArrayList<INode> getChildren();

	public String getId();

	public boolean searchChild(INode node);

	public void removeChild(INode node);
}

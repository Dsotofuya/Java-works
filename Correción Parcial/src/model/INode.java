package model;

import java.util.ArrayList;

public interface INode {

	public String getIcon();
	public void add(String data);
	public String getData();
	public void clear();
	public void removeChild(INode child);
	public ArrayList<INode> getChildren();
	public boolean search(String zone);
	public double getTax();
	public boolean getState();
	public void changeState();
	public void setColor(String hex);
	public String getColor();
}

package model.postalTree;

import java.util.ArrayList;

public interface INode {

	public void add(String name, String data, State state, Type type);
	public String getData();
	public void clear();
	public void removeChild(INode child);
	public ArrayList<INode> getChildren();
	public boolean search(String name);
	public State getState();
	public Type getType();
	public String getName();
	public String getIcon();
	public void setState(State state);
	public void rename(String name);
	public void edit(String data);
}

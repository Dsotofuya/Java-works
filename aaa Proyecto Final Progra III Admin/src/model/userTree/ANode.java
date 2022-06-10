package model.userTree;

import java.util.ArrayList;

public interface ANode {

	public void add(String name, String data);
	public void clear();
	public void removeChild(ANode child);
	public ArrayList<ANode> getChildren();
	public boolean search(String name);
	public String getName();
	public String getData();
	public String getIcon();
	public void setIcon(String path);
	public Type getType();
}

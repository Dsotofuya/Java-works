package model;

public class Archive {

	private String name;
	private long size;
	private String type;
	
	public Archive(String name, long size, String type) {
	this.name = name;
	this.size = size;
	this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public long getSize() {
		return size;
	}
	public String getType() {
		return type;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Archive [name=" + name + ", size=" + size + ", type=" + type + "]";
	}
	
}

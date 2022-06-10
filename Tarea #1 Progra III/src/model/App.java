package model;

public class App {

	public int id;
	public String name;
	public String image;
	public int size;
	
	public App(int id, String name, String image, int size) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.size = size;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "App [id=" + id + ", name=" + name + ", image=" + image + ", size=" + size + "]";
	}
	
}

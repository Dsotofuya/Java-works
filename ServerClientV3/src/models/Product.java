package models;

public class Product {

	private String name;
	private long year;
	
	public Product(String name, long year) {
		this.name = name;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", year=" + year + "]";
	}

	public String getServer() {
		return name.toUpperCase();
	}
}
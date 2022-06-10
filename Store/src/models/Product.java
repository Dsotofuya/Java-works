package models;

import java.io.IOException;

public class Product {

	private int id;
	private String name;
	private double price;
	
	public Product(String name, double price) throws NumberFormatException, IOException {
		this.id = FileManager.readId();
		this.name = name;
		this.price = price;
		FileManager.writeId(++id);
	}

	@Override
	public String toString() {
		return name + "  $" + price ;
	}

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}
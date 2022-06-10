package models;

import java.io.IOException;
import java.util.ArrayList;

public class Store {

	private ArrayList<Product> products;
	private ArrayList<Product> productsInCar;
	
	public Store() throws NumberFormatException, IOException {
		products = new ArrayList<>();
		productsInCar = new ArrayList<>();
		products.add(createProduct("Tinto", 500));
		products.add(createProduct("Cigarrillo", 400));
		products.add(createProduct("Aguita", 500));
		products.add(createProduct("Cafe", 1500));
		products.add(createProduct("Empanada", 1000));
		products.add(createProduct("Chicles", 100));
	}
	
	public static Product createProduct(String name, double price) throws NumberFormatException, IOException {
		return new Product(name, price);
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void addProductToCar(Product product) {
		productsInCar.add(product);
	}
	
	public Product searchProduct(int id) throws ProductNotFoundException {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		throw new ProductNotFoundException();
	}
	
	public double calculateTotal() {
		return productsInCar.stream().
				mapToDouble(p -> p.getPrice()).sum();
	}



	public ArrayList<Product> getProducts() {
		return products;
	}

	public ArrayList<Product> getProductsInCar() {
		return productsInCar;
	}
}
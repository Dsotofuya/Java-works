package models;

public class ProductNotFoundException extends Exception {

	private static final String MESSAGE = "Product not found :(";
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		super(MESSAGE);
	}
}

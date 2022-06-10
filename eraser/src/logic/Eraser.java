package logic;

public class Eraser {
	private String name;
	private int size;
	private double price;
	
	public Eraser() {
		name = "";
		size = 0;
		price = 0;
	}

	public String getName() {
		return name;
	}

public void setName(String name) {
		this.name = name;
}

	public int getSize() {
		return size;
	}

		public void setSize(int size) {
			this.size = size;
		}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}

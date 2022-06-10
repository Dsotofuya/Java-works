package Model;

public class Hardware {

	private static int id;
	private int idVar;
	private String name;
	private String description;
	private String quantity;
	private String price;
	
	public Hardware(String name, String description, String quantity, String price) {
	this.name = name;
	this.description = description;
	this.quantity = quantity;
	this.price = price;
	this.idVar = id++;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Hardware.id = id;
	}

	public int getIdVar() {
		return idVar;
	}

	public void setIdVar(int idVar) {
		this.idVar = idVar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}	
}

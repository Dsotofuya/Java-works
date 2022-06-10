package model;

public class Model {
	private int model;
	private int value;
	
	public Model(int model, int value) {
	this.model = model;
	this.value= value;
	
	}

	public int getModel() {
		return model;
	}

	public int getValue() {
		return value;
	}
	
	public String toString() {
		return  "Model: " + this.model + "," + "\n" + "Value: " + this.value + "\n";
	}

	public void setModel(int model) {
		this.model = model;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

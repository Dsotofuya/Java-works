package model;

import java.text.DecimalFormat;

public class Vehicle {
	private String brand;
	private String reference;
	private int model;
	private String licensePlate;
	private double value;
	private Person owner;
	
	// Metodos constructores
	public Vehicle() {
	}
	
	public Vehicle(String brand, String reference, int model, 
			String licensePlate, double value) {
		this.brand = brand;
		this.reference = reference;
		this.model = model;
		this.licensePlate = licensePlate;
		this.value = value;
	}

	public Vehicle(String brand, String reference, int model, 
			String licensePlate, double value, Person owner) {
		this.brand = brand;
		this.reference = reference;
		this.model = model;
		this.licensePlate = licensePlate;
		this.value = value;
		this.owner = owner;
	}


	// Metodos modificadores
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setModel(int model) {
		this.model = model;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	//Metodos analizadores
	
	public String getBrand() {
		return brand;
	}
	public String getReference() {
		return reference;
	}
	public int getModel() {
		return model;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public double getValue() {
		return value;
	}
	public Person getOwner() {
		return owner;
	}
	
	public void incrementValue(double percentage){
		value = value + value * percentage/100;
		// value += value * percentage/100;
		// setValue(value + value * percentage/100);
	}
	
	public void decrementValue(){
		if (model >= 2010){
			value = value - value * 0.1;
			// value = value - value * 10/100;
			// value -= value * 0.1;
			// setValue (getValue() - getValue() * 0.1);
		} else
			value = value - value * 0.15;
	}
	
	public String toString(){
		DecimalFormat df = new DecimalFormat("#,###.##");
		return "Marca: " + getBrand() +
				"\nReferencia: " + getReference() +
				"\nModelo: " + getModel() +
				"\nPlaca: " + getLicensePlate() +
				"\nValor: " + df.format(getValue()) +
				"\n*** Propietario ***" +
				"\n" + getOwner();
	}

}










package models;

public enum TypeOfVehicle {
	GRANDE ("Carro grande"), PEQUE�O ("Carro peque�o"), ALTO_CILINDAJE ("Moto de alto cilindraje"), REGULAR ("Moto regular/ de ciudad");
	private String text;
	private TypeOfVehicle(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
	
}
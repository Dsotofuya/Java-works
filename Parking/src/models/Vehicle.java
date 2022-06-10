package models;

public abstract class Vehicle {
	protected TypeOfVehicle type;
	protected String plate;
	protected StateOfVehicle state;
	
	public Vehicle(TypeOfVehicle type, String plate, StateOfVehicle state) {
		this.type = type;
		this.plate = plate;
		this.state = state;
	}
	
	public abstract StateOfVehicle park();
	
	public void setState(StateOfVehicle state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return ("Placa: " + plate + "---- Estado: " + state);
	}
}

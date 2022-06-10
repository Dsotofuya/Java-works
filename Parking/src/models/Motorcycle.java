package models;

public class Motorcycle extends Vehicle{

	public Motorcycle(TypeOfVehicle type, String plate, StateOfVehicle state) {
		super(type, plate, state);
	}

	@Override
	public StateOfVehicle park() {
		setState(StateOfVehicle.PARQUEADO);
		return state;
	}
}

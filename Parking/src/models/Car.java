package models;

public class Car extends Vehicle {
	
	public Car(TypeOfVehicle type, String plate, StateOfVehicle state) {
		super(type, plate, state);
	}
	@Override
	
	public StateOfVehicle park(){
		if(state == StateOfVehicle.LAVADO) {
		setState(StateOfVehicle.PARQUEADOS_Y_LAVADOS);
		}else {
			setState(StateOfVehicle.PARQUEADO);
		}
		return state;
	}
	
	public void wash(){
		if(state == StateOfVehicle.PARQUEADO) {
			setState(StateOfVehicle.PARQUEADOS_Y_LAVADOS);
			}else {
				setState(StateOfVehicle.LAVADO);
			}
	}
}

package models;

public enum StateOfVehicle {
	 LAVADO ("Lavado"), PARQUEADO("Parqueado"), PARQUEADOS_Y_LAVADOS ("Parqueado y lavado");
		
private String text;
	
	private StateOfVehicle(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
	
}
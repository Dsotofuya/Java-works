package control;


public enum PMenu {
	REGISTER_PRODUCT("Registrar vehiculo"), WASH_VEHICLE("Lavar vehiculo"), 
	TAKE_PARKING_BILL("Factura"), SHOW_AVAILABLE_PLACES("Mostrar cupos disponibles"), MOTOCYCLES_AT_PARKING ("Motos parqueadas"), PORCENTAGE_PARKING ("Porcentajes de servicios usados"), BACK_MENU("Ir al menú anterior");
	
	private String text;
	
	private PMenu(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
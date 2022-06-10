package control;

public enum ResourceMenu {
	AVALIBLE_SOAP("Cantidad de jab�n disponible"), WATER_REMAIN("Agua disponible"), 
	RENTABLE_TYPE_OF_SERVICE("Recomendaci�n de servicio en el negocio"), MONEY_COLLECT("Ganancia"), BACK_MENU("Ir al men� anterior");
	
	private String text;
	
	private ResourceMenu(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
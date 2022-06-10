package control;

public enum ResourceMenu {
	AVALIBLE_SOAP("Cantidad de jabón disponible"), WATER_REMAIN("Agua disponible"), 
	RENTABLE_TYPE_OF_SERVICE("Recomendación de servicio en el negocio"), MONEY_COLLECT("Ganancia"), BACK_MENU("Ir al menú anterior");
	
	private String text;
	
	private ResourceMenu(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
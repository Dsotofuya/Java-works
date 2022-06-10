package controllers;

public enum Action {
	ADD_PERSON("Agregar persona"),
	SHOW_PERSON_lIST("Mostrar lista personas"),
	SHOW_FILTER("Filtrar por edad");
	private final String text;
	
	private Action(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
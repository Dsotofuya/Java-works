package co.edu.uptc.models;

public enum TypeDocument {

	TARJETA(1,"tarjeta de Identidad"),CEDULA(2,"Cedula de ciuidadania"),PASAPORTE(3,"Pasaporte");
	
	private int id;
	private String nombre;
	
	private TypeDocument(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	
	
	
}

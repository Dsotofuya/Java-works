package model;

public enum TypeDocument {

	TI(1,"Tarjeta de Identidad"),CC(2,"Cedula de ciuidadania"),PE(3,"Pasaporte");
	
	private int id;
	private String name;
	
	private TypeDocument(int id, String name) {
		this.id = id;
		this.name = name;
	}

	
	
	
}

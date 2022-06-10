package co.edu.uptc.models;

public class Reserva {

	private Person person;
	private char fila;
	private Integer columna;
	
	
	
	
	public Reserva(Person person, char fila, Integer columna) {
		this.person = person;
		this.fila = fila;
		this.columna = columna;
	}

	public Reserva(){
		
	}



	public Person getPerson() {
		return person;
	}




	public void setPerson(Person person) {
		this.person = person;
	}




	public char getFila() {
		return fila;
	}




	public void setFila(char fila) {
		this.fila = fila;
	}




	public Integer getColumna() {
		return columna;
	}




	public void setColumna(Integer columna) {
		this.columna = columna;
	}




	@Override
	public String toString() {
		return "Reserva: \nperson: " + person + "\nAsiento=" + fila + columna ;
	}
 
	public String toStringReservados(){
		return "Reserva: \nNombre: "+person+"\nAsiento: "+fila+""+columna;
	}
	
	
	
	
}

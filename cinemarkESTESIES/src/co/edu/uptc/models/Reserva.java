package co.edu.uptc.models;

public class Reserva {

	private Person person;
	private Integer fila;
	private Integer columna;
	
	
	
	
	public Reserva(Person person, Integer fila2, Integer columna) {
		this.person = person;
		this.fila = fila2;
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




	public Integer getFila() {
		return fila;
	}




	public void setFila(Integer fila) {
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
		return "Reserva: \nUsuario: "+person+"\nAsiento: "+((char) (65 + fila))+""+(columna+1);
	}
 
	
	
	
	
}

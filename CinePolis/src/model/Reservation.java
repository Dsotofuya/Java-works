package model;

public class Reservation {

	private Person person;
	private Integer row;
	private Integer column;
		
	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public Integer getRow() {
		return row;
	}


	public void setRow(Integer row) {
		this.row = row;
	}


	public Integer getColumn() {
		return column;
	}


	public void setColumn(Integer column) {
		this.column = column;
	}

	@Override
	public String toString() {
		return "RESERVA: \n Usuario: "+person+"\n Puesto: "+((char) (65 + row))+""+(column+1);
	}
 
	
	
	
	
}

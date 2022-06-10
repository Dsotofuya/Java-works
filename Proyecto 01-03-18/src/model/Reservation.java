package model;

public class Reservation {
	public Person person;
	public int row;
	public int column;

	public Reservation(Person person, int row, int column) {
		super();
		this.person = person;
		this.row = row;
		this.column = column;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}

package control;

import exeptions.MyExeption;
import model.DocType;
import model.Person;
import model.Reservation;

public class Controller {

	private final static int ROW = 100;
	private final static int COLUNM = 100;

	private Reservation[][] reservations;

	public Controller() {
		reservations = new Reservation[ROW][COLUNM];
	}

	public void createReservation(Integer row, Integer column, String name, String lastName, DocType docType, int docNumber, String gender, String age) {
		Person person = new Person(name, lastName, docType, docNumber, gender, age);
		Reservation reservation = new Reservation(person, column, row);
		reservations[row][column] = reservation;
	}

	public void editReservation(byte row, byte column, String name, String lastName, DocType docType, int docNumber, String gender, String age)
			throws MyExeption {
		Reservation reservation = reservations[row][column];

		if (reservation != null) {
			if (name != null && !name.equals("")) {
				reservation.getPerson().setName(name);
			}
			if (lastName != null && !lastName.equals("")) {
				reservation.getPerson().setLastName(lastName);
			}
			if (docType != null) {
				reservation.getPerson().setDocType(docType);
			}
			if (docNumber != 0) {
				reservation.getPerson().setDocNumber(docNumber);
			}
			if (gender != null) {
				reservation.getPerson().setGender(gender);
			}
			if (age != null && !age.equals("")) {
				reservation.getPerson().setBornDay(age);
			}
		} else {
			throw new MyExeption("No existe una reserva en la fila " + row + "y columna " + column);
		}
	}
	
	public Reservation showReservation(Integer row, Integer column){
		return reservations[row][column];
	}
	
	public void deleteReservation(byte row, byte column) throws MyExeption {
		Reservation reservation = reservations[row][column];
		if (reservation != null) {
			reservations[row][column] = null;
		} else {
			throw new MyExeption("No existe una reserva en la fila " + row + "y columna " + column);
		}
	}	
	
	public int personsByGender(Reservation reservation){
		int auxWoman = 0;
		int auxMen = 0;
		int auxOther = 0;
		for (int i = 0; i < reservations.length; i++) {
			for (int j = 0; j < reservations.length; j++) {
				if((reservation.getPerson().getGender() != null) && reservation.getPerson().getGender() == "Mujer"){
					auxWoman++;
				}if ((reservation.getPerson().getGender() != null) && reservation.getPerson().getGender() == "Hombre") {
					auxMen++;
				}if ((reservation.getPerson().getGender() != null) && reservation.getPerson().getGender() == "Otro" ) {
					auxOther++;
				}
			}
		}
		return auxWoman + auxMen + auxOther;
	}
	
/*	public int personsByAge(Reservation reservation){
		int auxAge = 0;
		for (int i = 0; i < reservations.length; i++) {
			for (int j = 0; j < reservations.length; j++) {
				if (reservation.getPerson().calculateAge() = 18) {
					
				}
			}
		}
	}  */
	
	public Reservation[] showByRow(byte row){
		return reservations[row];
	}
	
	public Reservation[] showByColumn(byte column){
		return reservations[column];
	}

}
/*
 * EqualsIgnoreCase ignora las mayusculas
 */
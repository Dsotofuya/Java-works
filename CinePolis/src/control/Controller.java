package control;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import constants.Constants;
import exeptions.Exceptions;
import model.Person;
import model.Reservation;
import view.JframeMain;

public class Controller {

	private JframeMain main; // M
	private Reservation reservations[][];
	private ArrayList<Reservation> reservationRows; // C
	private ArrayList<Reservation> reservationColumns;
	private ArrayList<Reservation> reservationsDiagonal; // V
	private ArrayList<Reservation> reservaDiagonal2;
	private ArrayList<Reservation> womans;
	private ArrayList<Reservation> listReservations;
	private ArrayList<Reservation> under18;

	public Controller() {
		reservationRows = new ArrayList<Reservation>();
		reservationColumns = new ArrayList<Reservation>();
		reservationsDiagonal = new ArrayList<Reservation>();
		reservaDiagonal2 = new ArrayList<Reservation>();
		womans = new ArrayList<Reservation>();
		listReservations = new ArrayList<Reservation>();
		under18 = new ArrayList<Reservation>();
		reservations = new Reservation[Constants.ROW][Constants.COLUMN];
	}

	public void createReservation(Integer row, Integer column, String name, String lastName, String docNumber,
			String type, String gender, String date) {
		Person person = new Person(name, lastName, docNumber, type, gender, date);
		Reservation reservation = new Reservation();
		reservations[row][column] = reservation;
	}

	public void updateReservation(Integer row, Integer column, String name, String lastName, String docNumber,
			String doc) throws Exceptions {
		Reservation reservation = reservations[row][column];
		if (reservation != null && !name.equals("")) {
			if (name != null) {
				reservation.getPerson().setName(name);
			}
			if (lastName != null && !lastName.equals("")) {
				reservation.getPerson().setLastName(lastName);
			}
			if (docNumber != null && !docNumber.equals("")) {
				reservation.getPerson().setLastName(docNumber);
			}
			if (doc != null && !doc.equals("")) {
				reservation.getPerson().setLastName(docNumber);
			} else {
				throw new Exceptions("No existe una resreva en la fila " + column + "" + row);
			}
		}
	}

	public Reservation showReservation(Integer row, Integer column) {
		return reservations[row][column];
	}

	public void deleteReservation(Integer row, Integer column) throws Exceptions {
		Reservation reservation = reservations[row][column];
		if (reservation != null) {
			reservations[row][column] = null;
		} else {
			throw new Exceptions("No existe una reserva en la fila " + column + "" + row);
		}
	}

	public ArrayList<Reservation> showByColumn(Integer column) {
		for (int i = 0; i < reservations.length; i++) {
			for (int j = 0; j < reservations.length; j++) {
				if (reservations[i][j] != null && column == j) {
					reservationColumns.add(reservations[i][j]);
				}
			}
		}
		return reservationColumns;
	}
	
	public Reservation[] showByRow(Integer row) {
		return reservations[row];
	}

	public ArrayList<Reservation> showReservations() {
		for (int i = 0; i < reservations.length; i++) {
			for (int j = 0; j < reservations.length; j++) {
				if (reservations[i][j] != null) {
					listReservations.add(reservations[i][j]);
				} else {
				}
			}
		}
		return listReservations;
	}

	public ArrayList<Reservation> showDiagonal() {
		for (int i = 0; i < reservations.length; i++) {
			for (int j = 0; j < reservations.length; j++) {
				if (reservations[i][j] != null && i == j) {
					reservationsDiagonal.add(reservations[i][j]);
				}
			}
		}
		return reservationsDiagonal;
	}



	public ArrayList<Reservation> showDiagonal2() {
		for (int i = 0; i < reservations.length; i++) {
			for (int j = 0; j < reservations.length; j++) {
				if (reservations[i][j] != null && i != j) {
					reservationsDiagonal.add(reservations[i][j]);
				}
			}
		}
		return reservationsDiagonal;
	}

	public String showOnlyWomen() {
		int women = 0;
		for (int i = 0; i < reservations.length; i++) {
			for (int j = 0; j < reservations.length; j++) {
				if ((reservations[i][j] != null) && reservations[i][j].getPerson().getGender() == Constants.WOMAN) {
					women++;
				}

			}
		}
		return "Las mujeres registradas hasta el momento son: " + women;
	}

	public int calculateAge(String date){
		int age=0;
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate bornDay = LocalDate.parse(date,fmt);
		LocalDate now = LocalDate.now();
		Period period = Period.between(bornDay, now);
		age = period.getYears();
		return age;
	}

	public String showUnder18() {
		int age = 0;
		String date = "";
		int over18 = 0;
		for (int i = 0; i < reservations.length; i++) {
			for (int j = 0; j < reservations.length; j++) {
				if ((reservations[i][j] != null)) {
					date = reservations[i][j].getPerson().getAge();
					age = calculateAge(date);
					if (age <= 18) {
						over18++;
					}
				}
			}
		}

		return "Las personas menores de edad hasta el momento son: " + over18;
	}
}

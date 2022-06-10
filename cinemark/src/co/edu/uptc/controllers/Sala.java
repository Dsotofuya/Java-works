package co.edu.uptc.controllers;

import java.util.ArrayList;
import java.util.Date;

import co.edu.uptc.constants.Constants;
import co.edu.uptc.exceptions.CineExceptions;
import co.edu.uptc.models.Person;
import co.edu.uptc.models.Reserva;

public class Sala {

	private Reserva reservas[][];
	private ArrayList<Reserva> reservaFilas;
	private ArrayList<Reserva> reservaColumnas;
	private ArrayList<Reserva> reservaDiagonal1;
	private ArrayList<Reserva> reservaDiagonal2;
	private ArrayList<Reserva> mujeres;
	private ArrayList<Reserva> menoresDeEdad;

	public Sala() {
		reservaFilas = new ArrayList<Reserva>();
		reservaColumnas = new ArrayList<Reserva>();
		reservaDiagonal1 = new ArrayList<Reserva>();
		reservaDiagonal2 = new ArrayList<Reserva>();
		mujeres = new ArrayList<Reserva>();
		menoresDeEdad = new ArrayList<Reserva>();
		reservas = new Reserva[Constants.FILA][Constants.COLUMNA];

	}

	public void crearReserva(char fila, Integer columna, String nombre, String apellido, String doc, String documento) {
		Person persona = new Person(nombre, apellido, doc, documento);
		Reserva reser = new Reserva(persona, fila, columna);
		reservas[fila][columna] = reser;
	}

	// este metodo va a lanzar una excepcion cineExceptions.
	public void actualizarReserva(char fila, Integer columna, String nombre, String apellido, String doc,
			String documento) throws CineExceptions {
		Reserva reserva = reservas[fila][columna];
		if (reserva != null && !nombre.equals("")) {
			if (nombre != null) {
				reserva.getPerson().setName(nombre);
			} else if (apellido != null && !apellido.equals("")) {
				reserva.getPerson().setLastName(apellido);
			} else if (doc != null && !doc.equals("")) {
				reserva.getPerson().setLastName(doc);
			} else if (documento != null && !documento.equals("")) {
				reserva.getPerson().setLastName(doc);
			} else {
				throw new CineExceptions("No existe una resreva en la fila " + columna + "" + fila);
			}
		}
	}

	public void borrarReserva(char fila, Integer columna) throws CineExceptions {
		Reserva reserva = reservas[fila][columna];
		if (reserva != null) {
			reservas[fila][columna] = null;
		} else {
			throw new CineExceptions("No existe una reserva en la fila " + columna + "" + fila);
		}
	}

	public Reserva mostrarReserva(char fila, Integer columna) {
		return reservas[fila][columna];
	}
	// retornar las reservas de una fila,
	public ArrayList<Reserva> retornarFilas(char fila) {
		for (int i = 0; i < reservas.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if (fila == i) {
					reservaFilas.add(reservas[i][j]);
				}
			}
		}
		System.out.println(reservaFilas);
		return reservaFilas;
	}

	public ArrayList<Reserva> retornarColumnas(Integer columna) {
		for (int i = 0; i < reservas.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if (columna == j) {
					reservaColumnas.add(reservas[i][j]);
				}
			}
		}
		System.out.println(reservaColumnas);
		return reservaColumnas;
	}

	public ArrayList<Reserva> retornarDiagonal(char fila) {
		for (int i = 0; i < reservas.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if (i == j) {
					reservaDiagonal1.add(reservas[i][j]);
				}
			}
		}
		System.out.println(reservaColumnas);
		return reservaColumnas;
		// return null;
	}

	///

	public ArrayList<Reserva> retornarDiagonal2(char fila) {
		for (int i = 0; i < reservas.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if (i != j) {
					reservaDiagonal1.add(reservas[i][j]);
				}
			}
		}
		return reservaDiagonal1;
		// return null;
	}

	public ArrayList<Reserva> retornarMujeres(String sexo) {
		for (int i = 0; i < reservas.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if (sexo.equals(Constants.FEMENINO)) {
					mujeres.add(reservas[i][j]);
				}
			}
		}
		return mujeres;
		// return null;
	}

	public ArrayList<Reserva> retornarMenores(Date fecha) {
		for (int i = 0; i < reservas.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if (1 == 1) {
					menoresDeEdad.add(reservas[i][j]);
				}
			}
		}
		return null;
	}
}

package co.edu.uptc.controllers;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import co.edu.uptc.constants.Constants;
import co.edu.uptc.exceptions.CineExceptions;
import co.edu.uptc.models.Person;
import co.edu.uptc.models.Reserva;
import co.edu.uptc.views.JFMainWindow;

public class Sala {

	private JFMainWindow ventana;
																						//  M
	private Reserva reservas[][];
	private ArrayList<Reserva> reservaFilas;											//	C		
	private ArrayList<Reserva> reservaColumnas;
	private ArrayList<Reserva> reservaDiagonal1;										//	V
	private ArrayList<Reserva> reservaDiagonal2;
	private ArrayList<Reserva> mujeres;
	private ArrayList<Reserva> listReservas;
	private ArrayList<Reserva> menoresDeEdad;

	public Sala() {
		reservaFilas = new ArrayList<Reserva>();
		reservaColumnas = new ArrayList<Reserva>();
		reservaDiagonal1 = new ArrayList<Reserva>();
		reservaDiagonal2 = new ArrayList<Reserva>();
		mujeres = new ArrayList<Reserva>();
		listReservas = new ArrayList<Reserva>();
		menoresDeEdad = new ArrayList<Reserva>();
		reservas = new Reserva[Constants.FILA][Constants.COLUMNA];

	}

	public Person hacerPersona(String nombre, String apellido, String doc, String Tipo, String sexo, String fecha) {
		
		return null;
	}

	public void crearReserva(Integer fila, Integer columna,String nombre, String apellido, String doc, String tipo, String sexo, String fecha) {
		Person persona = new Person(nombre, apellido, doc, tipo,sexo,fecha);
		Reserva reser = new Reserva(persona, fila, columna);
		reservas[fila][columna] = reser;
	}

	// este metodo va a lanzar una excepcion cineExceptions.
	public void actualizarReserva(Integer fila, Integer columna, String nombre, String apellido, String doc,
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

	public void borrarReserva(Integer f, Integer columna) throws CineExceptions {
		Reserva reserva = reservas[f][columna];
		if (reserva != null) {
			reservas[f][columna] = null;
		} else {
			
			throw new CineExceptions("No existe una reserva en la fila " + columna + "" + f);
		}
	}

	public Reserva mostrarReserva(Integer fila, Integer columna) {
		return reservas[fila][columna];
	}

	// retornar las reservas de una fila,
	

	public ArrayList<Reserva> retornarColumna(Integer columna) {
		for (int i = 0; i < reservas.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if (reservas[i][j] !=null &&columna == j) {
					reservaColumnas.add(reservas[i][j]);
				}
			}
		}
		return reservaColumnas;
	}
	
	public ArrayList<Reserva> verReservas() {
		for (int i = 0; i < reservas.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if (reservas[i][j] != null) {
					listReservas.add(reservas[i][j]);
				}else{
				}
			}
		}
		return listReservas;
	}

	public ArrayList<Reserva> retornarDiagonal() {
		for (int i = 0; i < reservas.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if (reservas[i][j] !=null && i == j) {
					reservaDiagonal1.add(reservas[i][j]);
				}
			}
		}
		return reservaDiagonal1;
	}

	public Reserva[] retornarFila(Integer fila) {
		return reservas[fila];
	}


	public ArrayList<Reserva> retornarDiagonal2() {
		for (int i = 0; i < reservas.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if (reservas[i][j] !=null && i != j) {
					reservaDiagonal1.add(reservas[i][j]);
				}
			}
		}
		return reservaDiagonal1;
		// return null;
	}

	
	public String retornarMujeres() {
		int mujeres=0;
		for (int i = 0; i < reservas.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if ((reservas[i][j] != null)&& reservas[i][j].getPerson().getSexo()== Constants.FEMENINO){
				mujeres++;
				}
				
			}
		}
		return "las mujeres en la pelicula son: "+mujeres;
	}
	
	
	public int calcularEdad(String fecha){
		int edad=0;
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fecha,fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		edad = periodo.getYears();
		return edad;
	}

	public String retornarMenores() {
		int edad =0;
		String fecha ="";
		int mayores = 0;
		for (int i = 0; i < reservas.length; i++) {
			for (int j = 0; j < reservas.length; j++) {
				if ((reservas[i][j] != null)){
					fecha = reservas[i][j].getPerson().getEdad();
					edad = calcularEdad(fecha);
					if( edad<=18){
						mayores++;
					}
				}
			}
		}
	
		return "los menores de 18 anios que estan en la pelicula son: "+mayores;
	}
}

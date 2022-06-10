package views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import controllers.Action;
import models.Genre;
import models.Person;

public class Window {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public String getName() {
		return JOptionPane.showInputDialog(null, "Por favor ingrese su nombre:",
				"Nueva persona [1 de 3]", JOptionPane.QUESTION_MESSAGE);
	}

	public Genre getGenre() {
		return (Genre)JOptionPane.showInputDialog(
				null, "Por favor elija su genero.",
				"Nueva persona [2 de 3]", JOptionPane.QUESTION_MESSAGE,
				null, Genre.values(), Genre.values()[0]);
	}

	public Calendar getBornDate() throws ParseException {
		String textDate = JOptionPane.showInputDialog(null, "Por favor ingrese su fecha de nacimiento en el siguiente formato dd/mm/yyyy:",
				"Nueva persona [3 de 3]", JOptionPane.QUESTION_MESSAGE);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(DATE_FORMAT.parse(textDate));
		return calendar;
	}
	
	public Action getAction() {
		return (Action)JOptionPane.showInputDialog(
				null, "Por favor elija una opción.",
				"Menu", JOptionPane.QUESTION_MESSAGE,
				null, Action.values(), Action.values()[0]);
	}

	public void showDateError() {
		JOptionPane.showMessageDialog(null, "Error en el formato de la fecha",
				"Error", JOptionPane.ERROR_MESSAGE);	
	}

	public void showPersonList(Person[] personList) {
		JOptionPane.showMessageDialog(null, personList, "Personas",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void showPersonsByFilter(String string) {
		System.out.println(string);
	}
	
	public int getAge() {
		return Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese edad a filtrar:",
				null, JOptionPane.QUESTION_MESSAGE));
	}
}
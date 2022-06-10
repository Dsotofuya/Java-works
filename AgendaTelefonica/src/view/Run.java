package view;

import control.ControlPerson;
import logic.Person;

public class Run {
	public static void main(String[] args) {
		ControlPerson controlPerson = new ControlPerson();
		
		String nombre = "Johan";
		int numero = 13212432;
		String ciudad = "Sogamoso";
		
		controlPerson.addPersona(nombre, numero, ciudad);
		
		nombre = "David";
		numero = 13212432;
		ciudad = "Tunja";
		
		controlPerson.addPersona(nombre, numero, ciudad);
		
		nombre = "Diaz";
		numero = 13212432;
		ciudad = "Bogota";
		
		controlPerson.addPersona(nombre, numero, ciudad);
		
		controlPerson.viewMatriz(controlPerson.createMatriz());
		
	}

}

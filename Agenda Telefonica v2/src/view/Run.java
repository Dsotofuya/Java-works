package view;

import control.ControlPerson;

public class Run {
	public static void main(String[] args) {
		ControlPerson controlPerson = new ControlPerson();
		
		String nombre = "Johan";
		int numero = 13212432;
		String ciudad = "Sogamoso";
		
		controlPerson.addPerson(nombre, numero, ciudad);
		
		nombre = "David";
		numero = 888888;
		ciudad = "Tunja";
		
		controlPerson.addPerson(nombre, numero, ciudad);
		
		nombre = "Diaz";
		numero = 321387293;
		ciudad = "Bogota";
		
		controlPerson.addPerson(nombre, numero, ciudad);
		
		controlPerson.showPerson();
		
		System.out.println("------------------------------------------");
		
		controlPerson.deleteThis(13212432);
		
		controlPerson.showPerson();
	}

}

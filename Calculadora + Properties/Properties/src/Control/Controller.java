package Control;

import java.io.IOException;

import Model.Sesion;
import View.View;

public class Controller {

	private Sesion sesion;
	private View view;

	public Controller() {
		try {
			sesion = new Sesion();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		view = new View();
	}

	private String salu3() {
		String saludo = new String();
		saludo = "Hola " + sesion.getName() + " "+ sesion.getLastName() + " bienvenido a " + sesion.getTittle();
		return saludo;

	}
	
	private void run() {
		view.text(salu3());
	}

	public static void main(String[] args) {
		Controller c = new Controller();
		c.run();
	}
}

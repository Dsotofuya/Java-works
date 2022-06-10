package control;

import java.io.IOException;

import model.Sesion;
import view.View;

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

	private String greet() {
		return "Hola " + sesion.getName() + " "+ sesion.getLastName() +
			   " bienvenido a " + sesion.getTitle();
	}
	
	private void run()  {
		view.viewGreet(greet());
		try {
			sesion.changeName();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args)  {
		Controller c = new Controller();
		c.run();
	}
}

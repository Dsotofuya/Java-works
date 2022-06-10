package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import View.View;

public class Sesion {
	 private String tittle;
	 private String name;
	 private String lastName;
	 private View view;
	 
	 public Sesion() throws FileNotFoundException, IOException {
		 view = new View();
		 Properties p = new Properties();
		 p.load(new FileReader("src/Model/texto.properties"));
		tittle = p.getProperty("Sesion");
		name = p.getProperty("name");
		lastName=  p.getProperty("lastName");
		
		p.setProperty("Sesion", view.readString() );
		tittle = p.getProperty("Sesion");
		p.store(new FileWriter("src/Model/texto.properties"), "Nuevo titulo");
//		p.set
	}

	public String getTittle() {
		return tittle;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}
	 
	
}

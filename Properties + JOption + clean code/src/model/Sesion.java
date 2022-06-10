package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import view.View;

public class Sesion {
	private String title;
	private String name;
	private String lastName;
	private View view;

	public Sesion() throws FileNotFoundException, IOException {
		view = new View();
		Properties p = new Properties();
		p.load(new FileReader("src/zData/texto.properties"));
		title = p.getProperty("Sesion");
		name = p.getProperty("name");
		lastName = p.getProperty("lastName");
	}

	public void changeName() throws IOException {
		while (view.takeOption() == 0) {
			Properties p = new Properties();
			p.load(new FileReader("src/zData/texto.properties"));
			p.setProperty("name", view.readString());
			p.store(new FileWriter("src/zData/texto.properties"), "Nuevo nombre");
		}
		JOptionPane.showMessageDialog(null, "Adiós!");
	}

	public String getTitle() {
		return title;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

}

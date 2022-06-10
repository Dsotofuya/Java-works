package a;

import java.io.File;
import java.io.FileWriter;

public class b {
	public static void main(String[] args) {

		String saludo = "Hola";

		try {
			File archivo = new File("texto.txt");

			FileWriter escribir = new FileWriter(archivo, true);

			escribir.write(saludo);

			escribir.close();
		}

		catch (Exception e) {
			System.out.println("Error al escribir");
		}
	}
}

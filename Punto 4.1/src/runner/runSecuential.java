package runner;

import java.util.Scanner;

import controller.ControllerSecuential;

public class runSecuential {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//Ejecución mediante consola y esperando un valor numerico correspondiente a los programas
		System.out.println("Por favor ingrese cuantos programas desea correr con procesamiento en serie");
		Scanner scanner = new Scanner(System.in);
		new ControllerSecuential(scanner.nextInt());
	}

}

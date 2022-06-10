package view;

import control.ControlErase;

public class View {


	public static void main(String[] args) {
		ControlErase controlErase = new ControlErase();

		controlErase.initObjeto();

		controlErase.printErase(controlErase.getDates());

		System.out.println("-------------------------------------------");

		controlErase.printErase(controlErase.getDatesUno());

		System.out.println("-------------------------------------------");

		controlErase.printErase(controlErase.getDatesDos());

		System.out.println("-------------------------------------------");

		controlErase.printErase(controlErase.getDatesTres());
		
		System.out.println("------------------- SUMA ------------------------");

		int priceTotal = controlErase.sumaVector(controlErase.initObjeto());
		
		System.out.println("TOTAL: " + priceTotal);
		
		System.out.println("------------------- MATRIZ ------------------------");
		
		controlErase.printMatriz(controlErase.matriz());

	}

}

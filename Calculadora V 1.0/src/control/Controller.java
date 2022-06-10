package control;

import javax.swing.JOptionPane;

import model.*;
import view.Vista;

public class Controller {
	private Vista vista;

	public Controller() {
		vista = new Vista();
	}

	public void menu(int opcion, int x, int y) {
		do {
			opcion = vista.rMenu() ;
			switch (opcion) {
			case 1:
				 x  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
				 y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
				 Operacion.suma(x, y);
				 JOptionPane.showMessageDialog(null,(model.Operacion.suma(x, y)));
				break;
			case 2:
				x  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
				 y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
				Operacion.resta(x, y);
				JOptionPane.showMessageDialog(null,(model.Operacion.resta(x, y)));
				break;
			case 3:
				x  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
				y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
				Operacion.multiplicacion(x, y);
				JOptionPane.showMessageDialog(null,(model.Operacion.multiplicacion(x, y)));
				break;
			case 4:
				x  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
				y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
				Operacion.division(x, y);
				JOptionPane.showMessageDialog(null,(model.Operacion.division(x, y)));
				break;
			case 5:
				x  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
				y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
				Operacion.potencia(x, y);
				JOptionPane.showMessageDialog(null,(model.Operacion.potencia(x, y)));
				break;
			case 6:
				cambiarNombre();
			default:
				JOptionPane.showInputDialog("Ingrese un numero entre 1 y 6");
				break;
			}
		} while (opcion != 6);
	}
	
	 public String cambiarNombre(){
		 String nuevoNombre =  Calculadora.getNombre();
		 return nuevoNombre;
	 
	 }
}

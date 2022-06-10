package view;

import javax.swing.JOptionPane;

public class Vision {

	public String readString(String message) {
		String text = JOptionPane.showInputDialog(message);
		return text;
	}

	public int readInt(String message) {
		String text = JOptionPane.showInputDialog(message);
		return Integer.parseInt(text);
	}

	public double readDouble(String message) {
		String text = JOptionPane.showInputDialog(message);
		return Double.parseDouble(text);
	}

	public long readLong(String message) {
		String text = JOptionPane.showInputDialog(message);
		return Long.parseLong(text);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public int readHeaderMenu() {

		StringBuilder text = new StringBuilder();
		text.append("----------------------");
		text.append("BIENVENIDO AL TERMINAL");
		text.append("----------------------");
		text.append("\n ");
		text.append("\n                                               |Menu|");
		text.append("\n ");
		text.append("\n1.Informacion de Empresas.");
		text.append("\n2.Informacion de Rutas.");
		text.append("\n3.Informacion de Buses.");
		text.append("\n4.Informacion de Empleados.");
		text.append("\n5.Salir.");
		text.append("\n ");

		return readInt(text.toString());

	}

	public int readCompany() {

		StringBuilder text = new StringBuilder();
		text.append("-----------------------");
		text.append("Informacion de Empresas");
		text.append("-----------------------");
		text.append("\n ");
		text.append("\n                                               |Menu|");
		text.append("\n ");
		text.append("\n1.Agregar empresas.");
		text.append("\n2.Lista de empresas.");
		text.append("\n3.Modificar empresas.");
		text.append("\n4.Empresas con más recorriodos (Orden descendente).");
		text.append("\n5.Las tres empresas con más autobuses.");
		text.append("\n6.Las tres empresas con más empleados.");
		text.append("\n7.Regresar.");
		text.append("\n ");

		return readInt(text.toString());

	}

	public int readRoutes() {

		StringBuilder text = new StringBuilder();
		text.append("--------------------");
		text.append("Informacion de Rutas");
		text.append("--------------------");
		text.append("\n ");
		text.append("\n                                     |Menu|");
		text.append("\n ");
		text.append("\n1.Agregar rutas.");
		text.append("\n2.Lista de rutas.");
		text.append("\n3.Modificar rutas.");
		text.append("\n4.Regresar.");
		text.append("\n ");

		return readInt(text.toString());

	}

	public int readBuses() {

		StringBuilder text = new StringBuilder();
		text.append("--------------------");
		text.append("Informacion de Buses");
		text.append("--------------------");
		text.append("\n ");
		text.append("\n                                   |Menu|");
		text.append("\n ");
		text.append("\n1.Agregar buses.");
		text.append("\n2.Lista de buses.");
		text.append("\n3.Modificar buses.");
		text.append("\n4.Regresar.");
		text.append("\n ");

		return readInt(text.toString());

	}

	public int readEmployees() {

		StringBuilder text = new StringBuilder();
		text.append("------------------------");
		text.append("Informacion de Empleados");
		text.append("------------------------");
		text.append("\n ");
		text.append("\n                                               |Menu|");
		text.append("\n ");
		text.append("\n1.Agregar empleados.");
		text.append("\n2.Lista de empleados.");
		text.append("\n3.Modificar empleados.");
		text.append("\n4.Edad de los empleados(orden ascendente).");
		text.append("\n5.Establecer salario de los empleados (por kilometros).");
		text.append("\n6.Imprimir el salario de los empleados.");
		text.append("\n7.Regresar.");
		text.append("\n ");

		return readInt(text.toString());

	}

}

//walk like an egyptian
package view;

import javax.swing.JOptionPane;

public class Manager {

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

	public String readString(String message) {
		String text = JOptionPane.showInputDialog(message);
		return text;
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public int businessMenu() {
		StringBuilder txt = new StringBuilder();
		txt.append("\n" + "1. Empresas");
		txt.append("\n" + "2. Empleados");
		txt.append("\n" + "3. Buses");
		txt.append("\n" + "4. Rutas");
		txt.append("\n" + "5. Salir del programa");
		return readInt(txt.toString());
	}
	
	public int business() {
		StringBuilder txt = new StringBuilder();
		txt.append("\n" + "1. añadir empresa");
		txt.append("\n" + "2. modificar empresa ");
		txt.append("\n" + "3. mostrar empresa");
		txt.append("\n" + "4. Empresas con mas rutas");
		txt.append("\n" + "5. Empresas con mas empleados");
		txt.append("\n" + "6. Empresas con mas buses");
		txt.append("\n" + "7. volver");
		return readInt(txt.toString());
	}
	
	public int employeeMenu() {
		StringBuilder txt = new StringBuilder();
		txt.append("\n" + "1. Ingresar Nuevo Empleado");
		txt.append("\n" + "2. Modificar Empleado");
		txt.append("\n" + "3. Mostrar datos del empleado");
		txt.append("\n" + "4. Empleados por edad");
		txt.append("\n" + "5. Regresar");
		return readInt(txt.toString());
	}

	public int busMenu() {
		StringBuilder txt = new StringBuilder();
		txt.append("\n" + "1. Ingresar Nuevo bus");
		txt.append("\n" + "2. Modificar Bus");
		txt.append("\n" + "3. Mostrar datos del bus");
		txt.append("\n" + "4. Regresar");
		return readInt(txt.toString());
	}

	public int ruteMenu() {
		StringBuilder txt = new StringBuilder();
		txt.append("\n" + "1. Ingresar Nueva ruta");
		txt.append("\n" + "2. Modificar la ruta");
		txt.append("\n" + "3. Mostrar datos de la ruta");
		txt.append("\n" + "4. Regresar");
		return readInt(txt.toString());
	}
	
}
package view;

import javax.swing.JOptionPane;

import control.JOptionControl;

public class Vista {
	
	public static void main(String[] args) {
		JOptionControl control = new JOptionControl();
		control.menu();
		
	}

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
	
	public long readLong(String message){
		String txt = JOptionPane.showInputDialog(message);
		return Long.parseLong(txt);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);

	}
	
	public int showMenu(){
		StringBuilder text = new StringBuilder();
		text.append("Bienvenido al menu de la empresa");
		text.append("\n1. Crear	Conductores");
		text.append("\n2. Crear Rutas");
		text.append("\n3. Agregar vehiculos");
		text.append("\n4. Mostrar Conductores");
		text.append("\n5. Mostrar rutas");
		text.append("\n6. Mostar vehiculos");
		text.append("\n7. Salir");
		return readInt(text.toString());
	}
	public int readMenu(){
		StringBuilder text = new StringBuilder();
		text.append("Menu de vehiculos");
		text.append("\n1. Crear Taxi");
		text.append("\n2. Crear Bus");
		text.append("\n3. Crear Buseta");
		text.append("\n4. Regresar");
		return readInt(text.toString());
	}
	
	public int mostrarMenu(){
		StringBuilder text = new StringBuilder();
		text.append("Menu para mostrar los vehiculos");
		text.append("\n1. Mostrar Bus");
		text.append("\n2. Mostrar Buseta");
		text.append("\n3. Mostrar Taxi");
		text.append("\n4. Regresar");
		return readInt(text.toString());
	}
}

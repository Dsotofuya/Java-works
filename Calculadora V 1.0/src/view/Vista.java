package view;

import javax.swing.JOptionPane;

public class Vista {
	
	public String showMessage(String message){
		String txt = JOptionPane.showInputDialog(message);
		return txt;
	}
	
	public int readInt(String message) {
		String text = JOptionPane.showInputDialog(message);
		return Integer.parseInt(text);
	}

	public int rMenu() {
		StringBuilder text = new StringBuilder();
		text.append("Calculadora");
		text.append("\n1. Sumar");
		text.append("\n2. Restar");
		text.append("\n3. Multiplicar");
		text.append("\n4. Dividir");
		text.append("\n5. Potenciación");
		text.append("\n5. Cambiar nombre");
		text.append("\n7. Salir");
		return readInt(text.toString());
	}

}

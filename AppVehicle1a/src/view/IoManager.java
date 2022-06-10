 package view;

import javax.swing.JOptionPane;

public class IoManager {
	
	public String readString(String message){
		String text = JOptionPane.showInputDialog(message);
		return text;
	}
	
	public int readInt(String message){
		String text = JOptionPane.showInputDialog(message);
		return Integer.parseInt(text);
	}
	
	public double readDouble(String message){
		String text = JOptionPane.showInputDialog(message);
		return Double.parseDouble(text);
	}
	public void showMessage(String message){
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void showErrorMessage(String message){
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	public int readMenu(){
		StringBuilder text = new StringBuilder();
		text.append("MENU");
		text.append("\n1. Crear vehiculo");
		text.append("\n2. Crear propietario");
		text.append("\n3. Imprimir");
		text.append("\n4. Modificar vehiculo");
		text.append("\n5. Incrementar valor");
		text.append("\n6. Disminuir valor");
		text.append("\n7. Terminar");
		return readInt(text.toString());
	}
	public int readSubMenu(){
		StringBuilder text = new StringBuilder();
		text.append("MENU MODIFICAR VEHICULO");
		text.append("\n1. Marca");
		text.append("\n2. Referencia");
		text.append("\n3. Modelo");
		text.append("\n4. Placa");
		text.append("\n5. Valor");
		text.append("\n6. Doc. Id propietario");
		text.append("\n7. Nombre del propietario");
		text.append("\n8. Apellido del propietario");
		text.append("\n9. Retorna");
		return readInt(text.toString());
	}
}












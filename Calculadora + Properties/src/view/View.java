package view;

import javax.swing.JOptionPane;

public class View {

	
	public View() {
		options();
	}
	
	public int options(){
		String options[] = { "Suma",
	            "Resta",
	            "Multiplicaci�n",
	            "Divisi�n",
	            };
		return JOptionPane.showOptionDialog(null, "Que operaci�n desea realizar" , "Operaci�n", 0, 0, null, options, options[1]);
	}
	
	public static void main(String[] args) {
		new View();
	}
	
	public int takeDate(String message){
		return Integer.parseInt(JOptionPane.showInputDialog(message));
	}
	
	public int showOutcome(String message){
		return JOptionPane.showConfirmDialog(null, message, "Operacion", JOptionPane.YES_NO_OPTION);
	}
}

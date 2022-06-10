package view;

import javax.swing.JOptionPane;

public class View {

	public void viewGreet(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public String readString() {
		return JOptionPane.showInputDialog(null, "Escribe el nuevo nombre");
	}

	public int takeOption() {
		return JOptionPane.showConfirmDialog(null, "Desea cambiar el nombre?",
			   null, JOptionPane.YES_NO_OPTION);
	}

	// public String readString() {
	// Scanner sc = new Scanner(System.in);
	// String date = new String();
	// date = sc.next();
	// return date;
	// }
}

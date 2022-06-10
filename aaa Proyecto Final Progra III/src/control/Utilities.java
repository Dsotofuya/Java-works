package control;

import javax.swing.JOptionPane;

public class Utilities {

	public static void showMessageWarning(String mensaje, String title) {
		JOptionPane.showMessageDialog(null, mensaje, title, JOptionPane.WARNING_MESSAGE);
	}

	public static void showMessageError(String mensaje, String title) {
		JOptionPane.showMessageDialog(null, mensaje, title, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showMessage(String mensaje, String title) {
		JOptionPane.showMessageDialog(null, mensaje, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static String inputString(String mensaje, String title) {
		return JOptionPane.showInputDialog(null, mensaje, title, JOptionPane.PLAIN_MESSAGE);
	}
}

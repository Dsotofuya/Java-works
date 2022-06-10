package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import util.Utilities;

public class Messages {
	
	private Utilities utilities;
	public Messages() {
		utilities = new Utilities();
	}

	public  void confirmMessage(JFrame component, String text) {
		JOptionPane.showMessageDialog(component, text, "Confirmacion",JOptionPane.OK_OPTION, utilities.resizeIcon("confirmar.png", 40, 40));
	}
}

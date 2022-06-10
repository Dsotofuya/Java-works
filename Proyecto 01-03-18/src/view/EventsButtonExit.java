package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class EventsButtonExit implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		JOptionPane.showConfirmDialog(src, src.getText() + "¿Desea Salir?");
		System.exit(0);
		
	}

	
	
}

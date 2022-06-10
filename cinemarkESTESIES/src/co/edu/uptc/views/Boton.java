package co.edu.uptc.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton implements ActionListener {

	public Boton() {

		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			ImageIcon image = new ImageIcon(getClass().getResource("/co/edu/uptc/img/sillaOcupada.png"));
			setIcon(image);
	}


}

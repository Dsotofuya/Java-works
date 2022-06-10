package co.edu.uptc.views;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.constants.Constants;

public class PanelSur extends JPanel {

	private JFMainWindow ventana;
	private JLabel label;
	private JButton button,diagonalP,diagonalS,sexo;

	public PanelSur(JFMainWindow ventana) {
		this.ventana = ventana;
		this.setLayout(new GridLayout(1, 5));
		this.setVisible(true);
		this.initComponets();

	}

	public void initComponets() {
		label = new JLabel("");
		this.add(label);
		
		label = new JLabel("");
		this.add(label);
		
		button = new JButton("Diagonal Principal");
		button.addActionListener(ventana.getEventos());
		button.setActionCommand("FILAS");
		this.add(button);
		
		label = new JLabel("");
		this.add(label);
		
		label = new JLabel("");
		this.add(label);
		
	}

}

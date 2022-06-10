package co.edu.uptc.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCNorte extends JPanel{

	
	
	private JFMainWindow ventana;
	private PanelSillas sillas;
	private JLabel label;
	
	public PanelCNorte(JFMainWindow ventana) {
		this.ventana = ventana;
		this.setVisible(true);
		this.initComponets(ventana);

	}

	public void initComponets(JFMainWindow ventana) {
		label = new JLabel("  ELIJA UNO DE LOS ASIENTOS");
		label.setForeground(Color.WHITE);
		add(label);
	}
	
}

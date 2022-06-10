package co.edu.uptc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCentro extends JPanel{

	private JFMainWindow ventana;
	private PanelSillas sillas;
	private PanelCNorte cNorte;
	private PanelCSur cSur;
	
	
	
	public PanelSillas getSillas() {
		return sillas;
	}

	public void setSillas(PanelSillas sillas) {
		this.sillas = sillas;
	}

	public PanelCentro(JFMainWindow ventana) {
		this.ventana = ventana;
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.initComponets(ventana);

	}

	public void initComponets(JFMainWindow ventana) {
		cNorte = new PanelCNorte(ventana);
		cNorte.setBackground(Color.red);
		add(cNorte, BorderLayout.NORTH);
		sillas = new PanelSillas(ventana);
		sillas.setBackground(Color.red);
		add(sillas,BorderLayout.CENTER);
		cSur = new PanelCSur(ventana);
		cSur.setBackground(Color.red);
		add(cSur, BorderLayout.SOUTH);
		
	}

	
	
}

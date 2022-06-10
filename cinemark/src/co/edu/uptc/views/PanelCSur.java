package co.edu.uptc.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCSur extends JPanel{

	private JFMainWindow ventana;
	private JLabel label;
	private JButton boton;
	
	public PanelCSur(JFMainWindow ventana) {
		this.ventana = ventana;
		this.setLayout(new GridLayout(1,3));
		this.setBackground(Color.red);
		this.setVisible(true);
		this.initComponets(ventana);
	}

	public void initComponets(JFMainWindow ventana) {
		label = new JLabel();
		label.setBackground(Color.red);
		add(label);
		boton = new JButton("Ok");
		boton.addActionListener(ventana.getEventos());
		boton.setActionCommand("OK");
		
		add(boton);
		label = new JLabel();
		label.setBackground(Color.red);
		add(label);
	}
	
}


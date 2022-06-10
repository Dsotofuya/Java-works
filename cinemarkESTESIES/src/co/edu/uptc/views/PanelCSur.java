package co.edu.uptc.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.constants.Constants;

public class PanelCSur extends JPanel{

	private JFMainWindow ventana;
	private JLabel label;
	private JButton boton,actualizar,ver;
	
	public PanelCSur(JFMainWindow ventana) {
		this.ventana = ventana;
		this.setLayout(new GridLayout(2,2));
		this.setBackground(Color.red);
		this.setVisible(true);
		this.initComponets(ventana);
	}

	public void initComponets(JFMainWindow ventana) {
		actualizar = new JButton("ACTUALIZAR");
		actualizar.addActionListener(ventana.getEventos());
		actualizar.setActionCommand(Constants.ACTUALIZAR);
		add(actualizar);
		
		boton = new JButton("BORRAR");
		boton.addActionListener(ventana.getEventos());
		boton.setActionCommand(Constants.CANCELAR);
		add(boton);
		
		ver = new JButton("VER");
		ver.addActionListener(ventana.getEventos());
		ver.setActionCommand(Constants.VER);
		add(ver);
	}
	
}


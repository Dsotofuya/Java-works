package co.edu.uptc.views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.models.Person;

public class PanelWest extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFMainWindow ventana;
	private PanelUsuario usuario;
	private JLabel label;
	
	

	public PanelWest(JFMainWindow ventana) {
		this.ventana = ventana;
		this.setLayout(new GridLayout(2, 1));
		this.setVisible(true);
		this.initComponets(ventana);

	}

	
	
	public PanelUsuario getUsuario() {
		return usuario;
	}



	public void setUsuario(PanelUsuario usuario) {
		this.usuario = usuario;
	}



	public void initComponets(JFMainWindow ventana) {
			usuario = new PanelUsuario(ventana);
			usuario.setBackground(Color.red);
			add(usuario);
			label = new JLabel();
			label.setBackground(Color.red);
			add(label);
	}

	public Person hacerPersona(){
		return usuario.hacerPersona();
		 
	}
	 

}

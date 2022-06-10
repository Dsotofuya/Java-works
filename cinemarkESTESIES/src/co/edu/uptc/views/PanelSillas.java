package co.edu.uptc.views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.constants.Constants;

public class PanelSillas extends JPanel {

	private JFMainWindow ventana;
	private Boton[][] sillas;
	private Boton boton;
	private int fila;
	private int columna;
	
	

	public PanelSillas(JFMainWindow ventana) {
		this.ventana = ventana;
		this.setLayout(new GridLayout(Constants.FILA, Constants.COLUMNA));
		sillas = new Boton[Constants.FILA][Constants.COLUMNA];
		boton = new Boton();
		this.llenarMatriz();
	}
	

	
	public Boton getBoton() {
		return boton;
	}



	public void setBoton(Boton boton) {
		this.boton = boton;
	}



	public void llenarMatriz() {
		fila = 0;
		columna = 0;
		ImageIcon image = new ImageIcon(getClass().getResource("/co/edu/uptc/img/sillaVacia.png"));
		for (int i = 0; i < sillas.length; i++) {
			for (int j = 0; j < sillas[0].length; j++) {
				sillas[i][j] = new Boton();
				fila=i;
				columna=j;
				sillas[i][j].setBackground(Color.black);
				sillas[i][j].setIcon(image);
				sillas[i][j].addActionListener(ventana.getEventos());
				sillas[i][j].setActionCommand(i + "" + j);
				this.add(sillas[i][j]);
			}
		}
	}
	
	
	
	
	public int getFila() {
		return fila;
	}


	public void setFila(int fila) {
		this.fila = fila;
	}


	public int getColumna() {
		return columna;
	}


	public void setColumna(int columna) {
		this.columna = columna;
	}


	public JFMainWindow getVentana() {
		return ventana;
	}

	public void setVentana(JFMainWindow ventana) {
		this.ventana = ventana;
	}

	public Boton[][] getSillas() {
		return sillas;
	}

	public void setSillas(Boton[][] sillas) {
		this.sillas = sillas;
	}

}

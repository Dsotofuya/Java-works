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
	private JButton filas,columnas,diagonalP,diagonalS,sexo,edad;

	public PanelSur(JFMainWindow ventana) {
		this.ventana = ventana;
		this.setLayout(new GridLayout(1, 6));
		this.setVisible(true);
		this.initComponets();

	}

	public void initComponets() {
		filas = new JButton("Filas");
		filas.addActionListener(ventana.getEventos());
		filas.setActionCommand(Constants.FILAS);
		this.add(filas);
		
		columnas = new JButton("Columnas");
		columnas.addActionListener(ventana.getEventos());
		columnas.setActionCommand(Constants.COLUMNAS);
		this.add(columnas);
		
		diagonalP = new JButton("Diagonal Principal");
		diagonalP.addActionListener(ventana.getEventos());
		diagonalP.setActionCommand(Constants.DIAGONAL_P);
		this.add(diagonalP);
		
		diagonalS = new JButton("D");
		diagonalS.addActionListener(ventana.getEventos());
		//diagonalS.setActionCommand(Constants.DIAGONAL_P);
		this.add(diagonalS);
		
		sexo = new JButton("Mujeres");
		sexo.addActionListener(ventana.getEventos());
		sexo.setActionCommand(Constants.GENERO);
		this.add(sexo);
		
		edad = new JButton("Edad");
		edad.addActionListener(ventana.getEventos());
		edad.setActionCommand(Constants.EDAD);
		this.add(edad);
		
	}

}

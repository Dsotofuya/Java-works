package co.edu.uptc.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import co.edu.uptc.models.Reserva;

public class Eventos implements ActionListener {

	private PanelSillas sillas;
	private JFMainWindow ventana;
	private PanelUsuario usuario;
	private Reserva reserva;
	private Boton boton;

	//
	public Eventos(JFMainWindow ventana) {
		usuario = new PanelUsuario(ventana);
		this.ventana = ventana;
		reserva = new Reserva();
//		boton = ventana.getCentro().getSillas().getBoton(); 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		String[] val = comando.split("");
		Integer fila = Integer.parseInt(val[0]);
		Integer columna = Integer.parseInt(val[1]);
		JOptionPane.showConfirmDialog(null, "desea reservar el asiento: " + ((char) (65 + fila) + "" + (columna + 1)));
//		int valor = JOptionPane.showConfirmDialog(null, reserva);
//		if (JOptionPane.YES_OPTION == valor) {
//			ImageIcon image = new ImageIcon(getClass().getResource("/co/edu/uptc/img/sillaOcupada.png"));
////			boton.setIcon(image);
//		}

	}

}

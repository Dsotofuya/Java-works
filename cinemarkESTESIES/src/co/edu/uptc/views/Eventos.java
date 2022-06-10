package co.edu.uptc.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.uptc.constants.Constants;
import co.edu.uptc.controllers.Sala;
import co.edu.uptc.exceptions.CineExceptions;
import co.edu.uptc.models.Person;
import co.edu.uptc.models.Reserva;

public class Eventos implements ActionListener {

	private PanelSillas sillas;
	private JFMainWindow ventana;
	private PanelUsuario usuario;
	private Reserva reserva;
	private Boton boton;
	private Sala sala;
	private Person person;

	//
	public Eventos(JFMainWindow ventana) {
		usuario = new PanelUsuario(ventana);
		this.ventana = ventana;
		sala = new Sala();
		reserva = new Reserva();
		person = new Person();
	}


	@Override
	public void actionPerformed(ActionEvent e)throws NumberFormatException {
		person = ventana.hacerPersona();
		
		switch (e.getActionCommand()) {
		case Constants.FILAS:
			Integer fil = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de la fila"));
			JOptionPane.showConfirmDialog(null,sala.retornarFila(fil));
			break;
		case Constants.COLUMNAS :
			Integer col = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de la columna"));
			JOptionPane.showConfirmDialog(null,sala.retornarColumna(col));
			break;
		case Constants.DIAGONAL_P:
			JOptionPane.showConfirmDialog(null,sala.retornarDiagonal());
			break;
		case Constants.DIAGONAL_S:
			break;
		case Constants.GENERO:
			JOptionPane.showConfirmDialog(null,sala.retornarMujeres());
			break;
		case Constants.EDAD:
			JOptionPane.showConfirmDialog(null, sala.retornarMenores());
			
			break;
		case Constants.VER:
			JOptionPane.showConfirmDialog(null, sala.verReservas());
			break;
		case Constants.CANCELAR:
			Integer f = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de la fila"));
			Integer c = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de la columna"));
			JOptionPane.showConfirmDialog(null,"Desea cancelar la reserva?");
			try {
				sala.borrarReserva(f,c);
			} catch (CineExceptions e1) {
				JOptionPane.showConfirmDialog(null,"no se encuetra ninguna reserva en la posicion "+f+c);
				e1.printStackTrace();
			}
			break;
		case Constants.ACTUALIZAR:
			Integer fi = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de la fila"));
			Integer co = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de la columna"));
			String n = JOptionPane.showInputDialog("actualizar el nombre");
			String apell = JOptionPane.showInputDialog("actualizar el apellido");
			String docu = JOptionPane.showInputDialog("actualizar el numero de documento");
			String typeD =JOptionPane.showInputDialog("actualizar el tipo de documento");
			try {
				sala.actualizarReserva(fi, co, n, apell, docu, typeD);
				JOptionPane.showConfirmDialog(null, sala.mostrarReserva(fi, co));
			} catch (CineExceptions e1) {
				JOptionPane.showConfirmDialog(null,"no se encuetra ninguna reserva en la posicion "+fi+co);
				e1.printStackTrace();
			}
			break;
		default:
			String comando = e.getActionCommand();
			String[] val = comando.split("");
			Integer fila = Integer.parseInt(val[0]);
			Integer columna = Integer.parseInt(val[1]);
			JOptionPane.showConfirmDialog(null, "desea reservar el asiento: " + ((char) (65 + fila) + "" + (columna + 1)));
			sala.crearReserva(fila, columna,
					person.getName(),
					person.getLastName(),
					person.getnDoc(), 
					person.getTipo(),
					person.getSexo(),
					person.getEdad());
			JOptionPane.showConfirmDialog(null, sala.mostrarReserva(fila, columna));
			break;
		}
	}


}

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.Controller;
import model.Person;
import model.Reservation;

public class Events implements ActionListener {
	
	private Controller controller;
	private Person person;
	private Reservation reservation;
	private JframeMain jframeMain;
	private JPanelMidLeft user;
	
	
	public Events(JframeMain jframeMain) {
		user = new JPanelMidLeft(jframeMain);
		this.jframeMain = jframeMain;
		controller = new Controller();
		reservation = new Reservation();
		person = new Person();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		person = jframeMain.makePerson();
		String comando = e.getActionCommand();
		String[] val = comando.split("");
		Integer fila = Integer.parseInt(val[0]);
		Integer columna = Integer.parseInt(val[1]);
		JOptionPane.showConfirmDialog(null, "desea reservar el asiento: " + ((char) (65 + fila) + "" + (columna + 1)));
		
		controller.createReservation(
				fila, columna, person.getName(),
				person.getLastName(),
				person.getNumberDoc(), 
				person.getType(),
				person.getGender(),
				person.getAge());
		
		JOptionPane.showConfirmDialog(null, controller.showReservation(fila, columna));
		
	}

}

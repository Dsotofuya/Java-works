package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.Controller;
import model.Person;
import model.Reservation;

public class Events implements ActionListener {

	private Controller controller;
	private Reservation reservation;
	private JframeMain main;
	private JPanelMidRight right;
	private JPanelMidLeft left;
	private Person person;
	
	
	public Events(JframeMain main) {
		super();
		left = new JPanelMidLeft();
		this.main = main;
		reservation = new Reservation(null, 0, 0);
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		String comand = e.getActionCommand();

		String[] val = comand.split(" ");

		Integer row = Integer.parseInt(val[0]);

		Integer column = Integer.parseInt(val[1]);
	
		JOptionPane.showConfirmDialog(null, "Quiere reservar la silla: " + ((char) (65 + row) + "" + (column + 1)));
		
		controller.createReservation(row, column, person.getName(), person.getLastName(), person.getDocType(),
				person.getDocNumber(), person.getGender(), person.getBornDay());
		
		JOptionPane.showConfirmDialog(null, controller.showReservation(row, column));

		 System.out.print(((char)(65+row) +  (column+1)));
		 
		 System.out.print(column);
		 
		 System.out.println();
	}
}

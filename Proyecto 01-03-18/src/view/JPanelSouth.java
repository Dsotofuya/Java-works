package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelSouth extends JPanel {
	
	private JLabel emptyLabel, emptyLabel2, emptyLabel3, emptyLabel4 ;
	private Events events;
	private JButton exitButton;
	
	public JPanelSouth(){
	setLayout(new GridLayout(1,5));
	setBackground(Color.decode("#0b5ba1"));
	setVisible(true);
	init();
	}
	
	public void init(){
		emptyLabel  = new JLabel();
		add(emptyLabel);
		
		emptyLabel3  = new JLabel();
		add(emptyLabel3);
		
		exitButton = new JButton("Salir");
		add(exitButton);
		
		emptyLabel2 = new JLabel();
		add(emptyLabel2);
		
		emptyLabel4  = new JLabel();
		add(emptyLabel4);
		
		ActionListener eventButton  = new EventsButtonExit();
		exitButton.addActionListener(eventButton);
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}
	
	
	
}

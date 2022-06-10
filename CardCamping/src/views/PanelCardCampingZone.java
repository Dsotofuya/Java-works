package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.CampingZone;

import controllers.Events;

public class PanelCardCampingZone extends JPanel{//cards blueprint

	private static final long serialVersionUID = 1L;

	public PanelCardCampingZone(CampingZone campingZone, ActionListener controller) {//contained components
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.WHITE));//adds white border for every card
		
		JLabel lbInfo = new JLabel(campingZone.toString());//adds a label with cZone info
		lbInfo.setForeground(Color.WHITE);//sets superior lay white
		lbInfo.setFont(new Font("Arial", Font.PLAIN, 15));//sets fontType, style and size
		add(lbInfo, BorderLayout.CENTER);//adds and centers
		
		JButton btnReserve = new JButton("Reserve");//creates a button with the given name
		btnReserve.setName(String.valueOf(campingZone.getId()));//converts id int to string and sets it as name(JComponent functionality)
		btnReserve.addActionListener(controller);//links to controller events
		btnReserve.setBackground(Constants.COLOR_BLUE);//sets button color
		btnReserve.setForeground(Color.WHITE);//sets frontFont color
		btnReserve.setActionCommand(Events.RESERVE.toString());//links to RESERVE event
		add(btnReserve, BorderLayout.PAGE_END);//adds button and locates it at the card's bottom
		
		if (campingZone.isAvailable()) {//checks availability with cZone method
			setBackground(Constants.COLOR_GREEN);//when available sets the card color green
		}else{
			btnReserve.setActionCommand(Events.CHECK_OUT.toString());//changes button event(function)
			btnReserve.setText("Check Out");//changes button text
			setBackground(Constants.COLOR_RED);//when occupied sets the card color red
		}
	}
}
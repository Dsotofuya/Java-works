package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.Events;

public class GenericPanel extends JPanel{
	private static final long serialVersionUID = -2708564640659570565L;

	private static final String BACKGROUND = "#FFF5B3";
	private static final String BUTTON_BACKGROUND = "#A699FF";
	private static final String BUTTON_TEXT = "Get Users";

	private JButton btn;
	
	public GenericPanel(ActionListener control) {
		setBackground(Color.decode(BACKGROUND));
		btn = new JButton(BUTTON_TEXT);
		btn.addActionListener(control);
		btn.setBackground(Color.decode(BUTTON_BACKGROUND));
		btn.setActionCommand(Events.GETLIST.toString());
		add(btn);
	}

}

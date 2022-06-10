package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Events;

public class GenericPanel extends JPanel{
	private static final long serialVersionUID = -2708564640659570565L;

	private static final String BACKGROUND = "#FFF5B3";
	private static final String BUTTON_BACKGROUND = "#A699FF";
	private static final String BUTTON_TEXT = "Find";

	private JTextField field, fieldgeneric;
	private JButton btn;
	private JLabel label;
	
	public GenericPanel(ActionListener control) {
		setBackground(Color.decode(BACKGROUND));
		field = new JTextField();
		field.setPreferredSize(new Dimension(200, 30));
		add(field);
		fieldgeneric = new JTextField();
		fieldgeneric.setPreferredSize(new Dimension(200, 30));
		add(fieldgeneric);
		btn = new JButton(BUTTON_TEXT);
		btn.addActionListener(control);
		btn.setBackground(Color.decode(BUTTON_BACKGROUND));
		btn.setActionCommand(Events.value.toString());
		add(btn);
		label = new JLabel();
		add(label);
	}
	
	public String fieldText() {
		return field.getText();
	}
	
	public String genericFielText() {
		return fieldgeneric.getText();
	}
	
	public void setLabelText(String text) {
		label.setText(text);
	}
}

package view.desktop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.Events;

public class AddDialog extends JDialog {
	private static final long serialVersionUID = -2708564640659570565L;

	private static final String BACKGROUND = "#B3B3B3";
	private static final String BUTTON_BACKGROUND = "#D9D9D9";

	private JTextField name, day, month, year;
	private JTextArea description;
	private JButton registerFirst, register, exam;
	private JLabel path;

	public AddDialog(ActionListener control) {
		setSize(new Dimension(300, 350));
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode(BACKGROUND));
		path = new JLabel();
		path.setPreferredSize(new Dimension(200, 30));
		path.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(path);
		exam = new JButton("...");
		exam.addActionListener(control);
		exam.setActionCommand(Events.SHOW_CHOOSER.toString());
		exam.setBackground(Color.decode(BUTTON_BACKGROUND));
		panel.add(exam);
		name = new JTextField();
		name.setPreferredSize(new Dimension(250, 30));
		name.setText("Name");
		panel.add(name);
		day = new JTextField("Day");
		day.setPreferredSize(new Dimension(50, 30));
		panel.add(day);
		month = new JTextField("Month");
		month.setPreferredSize(new Dimension(50, 30));
		panel.add(month);
		year = new JTextField("Year");
		year.setPreferredSize(new Dimension(60, 30));
		panel.add(year);
		description = new JTextArea("Description");
		description.setPreferredSize(new Dimension(250, 150));
		description.setLineWrap(true);
		panel.add(description);
		registerFirst = new JButton("Register First");
		registerFirst.addActionListener(control);
		registerFirst.setBackground(Color.decode(BUTTON_BACKGROUND));
		registerFirst.setActionCommand(Events.ADD_FIRST.toString());
		panel.add(registerFirst);
		register = new JButton("Register Last");
		register.addActionListener(control);
		register.setBackground(Color.decode(BUTTON_BACKGROUND));
		register.setActionCommand(Events.ADD_LAST.toString());
		panel.add(register);
		add(panel);
	}

	public void setPathText(String text) {
		path.setText(text);
	}

	public String getNameText() {
		return name.getText();
	}

	public String getDayText() {
		return day.getText();
	}

	public String getMonthText() {
		return month.getText();
	}

	public String getYearText() {
		return year.getText();
	}

	public String getDescriptionText() {
		return description.getText();
	}
}

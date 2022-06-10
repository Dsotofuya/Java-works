package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Events;

public class FindPanel extends JPanel {
	private static final long serialVersionUID = -2708564640659570565L;

	private static final String BACKGROUND = "#FFF5B3";
	private static final String BUTTON_TEXT = "Add task";

	private JTextField task, priority;
	private JButton add, takeRecess, getTask;

	public FindPanel(ActionListener control) {
		setBackground(Color.decode(BACKGROUND));
		setPreferredSize(new Dimension(500, 100));
		task = new JTextField();
		task.setPreferredSize(new Dimension(200, 30));
		add(task);
		priority = new JTextField();
		priority.setPreferredSize(new Dimension(50, 30));
		add(priority);
		add = new JButton(BUTTON_TEXT);
		add.addActionListener(control);
		add.setBackground(Color.white);
		add.setActionCommand(Events.ADD.toString());
		add(add);
		getTask = new JButton("Get Principal Task");
		getTask.setPreferredSize(new Dimension(150, 30));
		getTask.addActionListener(control);
		getTask.setBackground(Color.white);
		getTask.setActionCommand(Events.GET.toString());
		add(getTask);
		takeRecess = new JButton("Take Recess: 0");
		takeRecess.setPreferredSize(new Dimension(150, 30));
		takeRecess.setEnabled(false);
		takeRecess.addActionListener(control);
		takeRecess.setBackground(Color.white);
		takeRecess.setActionCommand(Events.TAKE_RECESS.toString());
		add(takeRecess);

	}

	public String getTaskText() {
		return task.getText();
	}

	public String getPriorityText() {
		return priority.getText();
	}

	public void setRecess(int lastEvent) {
		takeRecess.setText("Take Recess: " + lastEvent + " segs");
		takeRecess.setEnabled(true);
	}

	public void enableBtnAddTask() {
		add.setEnabled(true);
	}
	
	public void disableBtnAddTask() {
		add.setEnabled(false);
	}
	
	public void enableBtnRecess() {
		takeRecess.setEnabled(true);
	}
	
	public void disableBtnRecess() {
		takeRecess.setEnabled(false);
	}
	
	public void disableBtnGetTask() {
		getTask.setEnabled(false);
	}
	
	public void enableBtnGetTask() {
		getTask.setEnabled(true);
	}
}

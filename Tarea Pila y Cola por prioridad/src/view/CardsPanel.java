package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import control.Events;

public class CardsPanel extends JPanel {
	private static final long serialVersionUID = -1210966928811455084L;

	private static final String BACKGROUND = "#FFF5B3";
	
	private JLabel task, time;
	private JButton endTask;
	
	
	public CardsPanel(ActionListener control) {
		setPreferredSize(new Dimension(500, 350));
		setBackground(Color.decode(BACKGROUND));
		task = new JLabel("No task", SwingConstants.CENTER);
		task.setFont(new Font("Arial", Font.BOLD, 30));
		task.setPreferredSize(new Dimension(300, 50));
		add(task);
		time = new JLabel("Time: ", SwingConstants.CENTER);
		time.setFont(new Font("Arial", Font.BOLD, 20));
		time.setPreferredSize(new Dimension(300, 200));
		add(time);
		endTask = new JButton("End Task");
		endTask.setPreferredSize(new Dimension(250, 30));
		endTask.setEnabled(false);
		endTask.addActionListener(control);
		endTask.setBackground(Color.white);
		endTask.setActionCommand(Events.COMPLETE_TASK.toString());
		add(endTask);
	}

	public void fill(String task){
		this.task.setText(task);
	}
	
	public void updateTime(int i) {
		this.time.setText(String.valueOf(i));
	}
	
	public void enableBtn() {
		endTask.setEnabled(true);
	}
	
	public void disableBtn() {
		endTask.setEnabled(false);
	}
}

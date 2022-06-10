package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Events;

public class GameOverPanel extends JPanel{
	private static final long serialVersionUID = -4498737979637437285L;

	private JTextField userField;
	private JButton accept;
	private JButton restart;
	private JButton menu;
	private JLabel score, gameOver;
	private ResourceBundle bundle;
	
	public GameOverPanel(ActionListener control, ResourceBundle bundle) {
		this.bundle = bundle;
		setBackground(Color.decode("#12702c"));
		gameOver = new JLabel(bundle.getString("gameOver"));
		gameOver.setFont(new Font("Arial", Font.BOLD, 50));
		gameOver.setPreferredSize(new Dimension(300, 60));
		add(gameOver);
		score = new JLabel();
		score.setFont(new Font("Arial", Font.BOLD, 30));
		score.setPreferredSize(new Dimension(300, 30));
		add(score);
		userField = new JTextField();
		userField.setPreferredSize(new Dimension(300, 40));
		add(userField);
		accept = new JButton(bundle.getString("accept"));
		accept.setPreferredSize(new Dimension(300, 30));
		accept.setActionCommand(Events.ACCEPT.toString());
		accept.addActionListener(control);
		accept.setFocusable(false);
		accept.setBackground(Color.decode("#32a852"));
		accept.setForeground(Color.WHITE);
		add(accept);
		restart = new JButton(bundle.getString("restart"));
		restart.setPreferredSize(new Dimension(300, 30));
		restart.setActionCommand(Events.RESTART.toString());
		restart.addActionListener(control);
		restart.setFocusable(false);
		restart.setBackground(Color.decode("#32a852"));
		restart.setForeground(Color.WHITE);
		add(restart);
		menu = new JButton(bundle.getString("menu"));
		menu.setPreferredSize(new Dimension(300, 30));
		menu.setActionCommand(Events.MENU.toString());
		menu.addActionListener(control);
		menu.setFocusable(false);
		menu.setBackground(Color.decode("#32a852"));
		menu.setForeground(Color.WHITE);
		add(menu);
	}
	
	public void setScore(int score) {
		this.score.setText(bundle.getString("score") + ": " +score);
	}
	
	public String getUserText() {
		return userField.getText();
	}
	
	public void cleanField() {
		userField.setText("");
	}
}

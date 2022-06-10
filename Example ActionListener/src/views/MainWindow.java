package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Actions;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public MainWindow(ActionListener actionListener) {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My project");
	
		JPanel panel = new JPanel();
		
		JButton btn = new JButton("Boton 1");
		btn.addActionListener(actionListener);
		btn.setActionCommand(Actions.ACCEPT.toString());
		panel.add(btn);
		
		add(panel, BorderLayout.CENTER);
		
		setVisible(true);
	}
}
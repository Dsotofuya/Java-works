package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	public MainWindow() {

		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Jpane pane = new Jpane();
		add(pane, BorderLayout.SOUTH);
		setVisible(true);
	}
}

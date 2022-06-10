package view;


import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class StatePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JProgressBar progressBar;
	
	public StatePanel() {
		this.setLayout(new GridLayout(1,1));
		progressBar = new JProgressBar(0, 100);
		progressBar.setStringPainted(true);
		this.add(progressBar);
	}
	
	
	public void increaste(int value) {
		progressBar.setValue(value);
		updateUI();
		repaint();
	}
}

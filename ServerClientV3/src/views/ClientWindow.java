package views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClientWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private JLabel lbTime;
	
	public ClientWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setTitle("Client");
		
		lbTime = new JLabel("Time:");
		lbTime.setFont(new Font("Arial", Font.PLAIN, 50));
		add(lbTime, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void updateLbTime(String time) {
		lbTime.setText("Time: " + time);
	}
}
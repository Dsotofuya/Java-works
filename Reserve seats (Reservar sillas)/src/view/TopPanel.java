package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TopPanel extends JPanel{
	private static final long serialVersionUID = 2699867398337249080L;

	private JLabel lastUpdate;
	
	public TopPanel() {
		setBackground(Color.DARK_GRAY);
		lastUpdate = new JLabel("Ultima actualización: ");
		lastUpdate.setForeground(Color.white);
		lastUpdate.setPreferredSize(new Dimension(600, 100));
		lastUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lastUpdate.setFont(new Font("Arial", Font.BOLD, 30));
		add(lastUpdate);
	}
	
	public void updateInfo(String text) {
		lastUpdate.setText(text);
	}
	
}

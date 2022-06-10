package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class TopPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	public TopPanel() {
		setBackground(Color.decode("#9ae3e2"));
		
		JLabel lostLb = new JLabel("Objetos Perdidos");
		lostLb.setFont(new Font("Raleway", Font.PLAIN, 50));
		add(lostLb);
		
		setIUManager();
	}
	
	private void setIUManager() {
		UIManager.put("Label.background", Color.WHITE);
		UIManager.put("Label.font", ConstantsGUI.RALEWAY_FONT);
		UIManager.put("Label.foreground", Color.BLACK);
		UIManager.put("Label.cursor", new Cursor(Cursor.HAND_CURSOR));
		UIManager.put("Button.font", ConstantsGUI.RALEWAY_FONT);
		UIManager.put("Button.background", Color.WHITE);
		UIManager.put("Button.foreground", Color.BLACK);
	}
}

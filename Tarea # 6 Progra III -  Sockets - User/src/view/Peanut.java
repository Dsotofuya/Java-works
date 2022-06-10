package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Peanut extends JFrame {

	private static final long serialVersionUID = 98857457528116079L;

	private static final String ICON_PATH = null;

	private AreasPanel areasPanel;
	
	public Peanut(ActionListener control) {
		super("Community Paragraph");
		setIconImage(new ImageIcon(ICON_PATH).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		areasPanel = new AreasPanel(control);
		add(areasPanel);
		setSize(900,400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public AreasPanel getAreasPanel() {
		return areasPanel;
	}
	
}

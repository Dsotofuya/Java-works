package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Peanut extends JFrame {
	private static final long serialVersionUID = -6644915693652104869L;

	private static final String ICON_PATH = "src/data/icon.png";
	private static final String TITTLE = "Image";

	private LeftPanel leftPanel;
	private CenterPanel centerPanel;

	public Peanut(ActionListener control) {
		super(TITTLE);
		setIconImage(new ImageIcon(ICON_PATH).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 550);
		setLocationRelativeTo(null);
		leftPanel = new LeftPanel(control);
		add(leftPanel, BorderLayout.WEST);
		centerPanel = new CenterPanel(control);
		add(centerPanel, BorderLayout.CENTER);
		setVisible(true);
		
	}

	public LeftPanel getLeftPanel() {
		return leftPanel;
	}

	public CenterPanel getCenterPanel() {
		return centerPanel;
	}
	
	public static void main(String[] args) {
		new Peanut(null);
	}

}

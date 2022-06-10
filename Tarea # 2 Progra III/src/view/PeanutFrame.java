package view;

import javax.swing.JFrame;

public class PeanutFrame extends JFrame{
	private static final long serialVersionUID = -8751728478684845174L;

	private static final String LANDSCAPE = "Landscape";
	
	private LandscapePanel landscapePanel;
	
	public PeanutFrame() {
		setSize(800,600);
		setLocationRelativeTo(null);
		setTitle(LANDSCAPE);
		landscapePanel = new LandscapePanel();
		add(landscapePanel);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PeanutFrame();
	}
}

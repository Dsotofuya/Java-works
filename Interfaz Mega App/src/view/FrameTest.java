package view;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

public class FrameTest extends JFrame {
private static final long serialVersionUID = -4824044665400003270L;

	private GridBagConstraints gbc;
	private CloudPanel cloudPanel;
	
	public FrameTest() {
//		setLayout(new GridBagLayout());
		cloudPanel = new CloudPanel();
//		gbc.anchor = GridBagConstraints.VERTICAL;
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.gridwidth =
		add(cloudPanel);
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameTest();
	}
}

package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelMidRight extends JPanel {

	protected static final int ROW = 10;
	protected static final int COLUMN = 10;

	private JframeMain jframeMain;

	private JButton[][] chairs;

	public JPanelMidRight(JframeMain jframeMain) {
		this.jframeMain = jframeMain;
		setLayout(new GridLayout(ROW, COLUMN));
		setVisible(true);
		setBackground(Color.decode("#0b5ba1"));
		
		ImageIcon image = new ImageIcon(getClass().getResource("/images/ChairEmpty.png"));
		chairs = new JButton[ROW][COLUMN];
		for (int i = 0; i < chairs.length; i++) {
			for (int j = 0; j < chairs[0].length; j++) {
				chairs[i][j] = new JButton("");
				chairs[i][j].setBackground(Color.decode("#0b5ba1"));
				chairs[i][j].setIcon(image);
				chairs[i][j].addActionListener(jframeMain.getEvents());
				chairs[i][j].setActionCommand(i + " " + j);
				add(chairs[i][j]);
			}
		}
	}

	public JframeMain getJframeMain() {
		return jframeMain;
	}

	public void setJframeMain(JframeMain jframeMain) {
		this.jframeMain = jframeMain;
	}

	public JButton[][] getChairs() {
		return chairs;
	}

	public void setChairs(JButton[][] chairs) {
		this.chairs = chairs;
	}
}

package view.northpanel;

import java.awt.Color;

import javax.swing.JPanel;

public class NorthPanel extends JPanel{
	private static final long serialVersionUID = -1024794063564629150L;
	
	private FindBarPanel findBarPanel;
	private JPanel emptyPanel;
	
	public NorthPanel() {
		setBackground(Color.white);
		emptyPanel = new JPanel();
		emptyPanel.setBackground(Color.white);
		add(emptyPanel);
		findBarPanel = new FindBarPanel();
		add(findBarPanel);
		add(emptyPanel);
	}
}

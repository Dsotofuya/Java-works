package view;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Control.Control;
import constants.Constants;

public class TopPanel extends JPanel {
	private static final long serialVersionUID = -1621735827501914591L;
	
	private JComboBox<String> gameCB;
	
	public TopPanel(Control control) {
		setPreferredSize(new Dimension(800, 50));
		gameCB = new JComboBox<>();
		gameCB.setPreferredSize(new Dimension(600, 30));
		gameCB.setActionCommand(Constants.GAMESELECTED);
		gameCB.addActionListener(control);
		add(gameCB);
		
	}
	
	public void fillCB(ArrayList<String> gameList) {
		for (String gameName : gameList) {
			gameCB.addItem(gameName);
		}
	}
	
	public String getText() {
		return (String) gameCB.getSelectedItem();
	}
}


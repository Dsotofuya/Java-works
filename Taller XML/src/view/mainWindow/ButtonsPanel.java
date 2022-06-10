package view.mainWindow;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Constants;
import Control.Controller;

public class ButtonsPanel extends JPanel {
	private static final long serialVersionUID = -4122757900092845689L;

	private JButton addWordBtn;
	private JButton addSynonymBtn;
	private GridBagConstraints gbc;
	
	public ButtonsPanel(Controller control) {
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		generateBasicGrid(gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		addWordBtn = new JButton(Constants.ADDWORDBTN);
		addWordBtn.setActionCommand(Constants.ADDWORD);
		addWordBtn.addActionListener(control);
		add(addWordBtn, gbc);
		gbc.gridx = 2;
		addSynonymBtn = new JButton(Constants.ADDSYNONYMBTN);
		addSynonymBtn.setActionCommand(Constants.ADDSYNONYM);
		addSynonymBtn.addActionListener(control);
		add(addSynonymBtn, gbc);
	}
	
	private void generateBasicGrid(GridBagConstraints c){
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 4; i++) {
			c.gridx = i;
			add(new JLabel(), c);
		}
	}
}

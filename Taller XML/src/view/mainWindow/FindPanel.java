package view.mainWindow;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Constants.Constants;
import Control.Controller;

public class FindPanel extends JPanel {
	private static final long serialVersionUID = -2031757900840156545L;

	private JLabel textLbl;
	private JTextField fieldTxtF;
	private JButton findBtn;
	private GridBagConstraints gbc;
	
	public FindPanel(Controller control) {
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		generateBasicGrid(gbc);
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		textLbl = new JLabel(Constants.TEXTLBL);		
		add(textLbl, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 8;
		gbc.weightx = 50;
		fieldTxtF = new JTextField(50);
		add(fieldTxtF, gbc);
		
		gbc.weightx = 0;
		gbc.gridx = 9;
		gbc.gridwidth = 1;
		findBtn = new JButton(Constants.FINDBTN);
		findBtn.setActionCommand(Constants.FIND);
		findBtn.addActionListener(control);;
		add(findBtn, gbc);
		
	}
	
	public String getSynonym() {
		return fieldTxtF.getText();
	}
	
	public void clean() {
		fieldTxtF.setText("");
	}
	
	private void generateBasicGrid(GridBagConstraints c){
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 10; i++) {
			c.gridx = i;
			add(new JLabel(), c);
		}
	}
}

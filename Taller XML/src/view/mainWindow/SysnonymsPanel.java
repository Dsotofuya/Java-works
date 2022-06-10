package view.mainWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Constants.Constants;
import Control.Controller;

public class SysnonymsPanel extends JPanel {
	private static final long serialVersionUID = -5345075238800940677L;

	private JButton previousBtn;
	private JButton nextBtn; 
	private JTextField synonymTxtF;
	private JLabel synonymsNumberLbl;
	private GridBagConstraints gbc;
	
	public SysnonymsPanel(Controller control) {
		setBorder(BorderFactory.createTitledBorder(null, Constants.BORDERSYNONYMSPANEL, 0, 0, new Font(getFont().toString(), 1, 13), Color.blue));
		setLayout(new GridBagLayout());
		gbc = new  GridBagConstraints();
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.BOTH;
		generateBasicGrid(gbc);
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		previousBtn = new JButton(Constants.PREVIOUSBTN);
		previousBtn.setActionCommand(Constants.AFTER);
		previousBtn.setEnabled(false);
		previousBtn.addActionListener(control);
		add(previousBtn, gbc);
		gbc.gridx = 1;
		gbc.gridwidth = 8;
		synonymTxtF = new JTextField(40);
		synonymTxtF.setEditable(false);
		add(synonymTxtF, gbc);
		gbc.gridx = 9;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		nextBtn = new JButton(Constants.NEXTBTN);
		nextBtn.setActionCommand(Constants.NEXT);
		nextBtn.setEnabled(false);
		nextBtn.addActionListener(control);
		add(nextBtn, gbc);
		gbc.gridy = 2;
		gbc.gridx = 4;
		gbc.gridwidth = 6;
		synonymsNumberLbl = new JLabel(Constants.SYNONYMSNUMBERLBL);
		add(synonymsNumberLbl, gbc);
	}
	
	public void setNumber(String number) {
		synonymsNumberLbl.setText(Constants.SYNONYMSNUMBERLBL + number);
	}
	
	public void setText(String text) {
		synonymTxtF.setHorizontalAlignment(JTextField.CENTER);
		synonymTxtF.setText(text);
	}
	
	public void clean() {
		synonymTxtF.setText("");
	}
	
	public void disableButtonAfter() {
		previousBtn.setEnabled(false);
	}
	
	public void disableButtonNext() {
		nextBtn.setEnabled(false);
	}
	
	public void enableButtonAfter() {
		previousBtn.setEnabled(true);
	}
	
	public void enableButtonNext() {
		nextBtn.setEnabled(true);
	}
	
	private void generateBasicGrid(GridBagConstraints c){
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 10; i++) {
			c.gridx = i;
			add(new JLabel(), c);
		} 
		for (int i = 0; i < 2; i++) {
			c.gridy = i;
			add(new JLabel(), c);
		}
	}
}

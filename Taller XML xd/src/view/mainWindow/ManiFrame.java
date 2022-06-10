package view.mainWindow;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Constants.Constants;
import Control.Controller;

public class ManiFrame extends JFrame{
	private static final long serialVersionUID = -4089388902583573056L;

	private FindPanel findPanel;
	private SysnonymsPanel sysnonymsPanel;
	private ButtonsPanel buttonsPanel;
	private GridBagConstraints gbc;
	
	public ManiFrame(Controller control) {
		super(Constants.MANITEXT);
		setSize(500, 170);
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		generateBasicGrid(gbc);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		findPanel = new FindPanel(control);
		add(findPanel, gbc);
		gbc.gridy = 1;
		sysnonymsPanel  = new SysnonymsPanel(control);
		add(sysnonymsPanel, gbc);
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 0, 0);
		buttonsPanel = new ButtonsPanel(control);
		add(buttonsPanel, gbc);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public String getSynonym() {
		return findPanel.getSynonym();
	}
	
	public void setNumber(String number) {
		sysnonymsPanel.setNumber(number);
	}
	
	public void setText(String text) {
		sysnonymsPanel.setText(text);
	}
	
	public void disableButtonAfter() {
		sysnonymsPanel.disableButtonAfter();
	}
	
	public void disableButtonNext() {
		sysnonymsPanel.disableButtonNext();
	}
	
	public void enableButtonAfter() {
		sysnonymsPanel.enableButtonAfter();
	}
	
	public void enableButtonNext() {
		sysnonymsPanel.enableButtonNext();
	}
	
	public void cleanFindPanel() {
		findPanel.clean();
	}
	
	public void cleanSynonymPanel() {
		sysnonymsPanel.clean();
	}
	
	private void generateBasicGrid(GridBagConstraints c){
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 1; i++) {
			c.gridx = i;
			add(new JLabel(), c);
		} 
		for (int i = 0; i < 3; i++) {
			c.gridy = i;
			add(new JLabel(), c);
		}
	}
}

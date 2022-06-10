package view.createAccount;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Constants.Constants;
import Control.Control;

public class CreateAccountPanel extends JPanel {
	private static final long serialVersionUID = -2195702808561044393L;

	private GridBagConstraints gbc;
	private JLabel createAccountLbl;
	private JTextField inputUserTxtf;
	private JTextField inputPasswordTxtf;
	private JCheckBox agreeTermsCkB;
	private JButton createAccountbtn;

	public CreateAccountPanel(Control control, Properties properties) {
		setBackground(Color.decode("#FFFFFF"));
		setPreferredSize(new Dimension(400, 300));
		gbc = new GridBagConstraints();
		generateBasicGrid(gbc);
		setLayout(new GridBagLayout());
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 20, 10, 20);
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		createAccountLbl = new JLabel();
		createAccountLbl.setForeground(Color.decode("#F15B40"));
		createAccountLbl.setFont(new Font("Arial", 4, 25));
		createAccountLbl.setText(properties.getProperty("createAccount"));
		add(createAccountLbl, gbc);
		gbc.gridy = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel(), gbc);
		gbc.gridy = 3;
		inputUserTxtf = new JTextField();
		inputUserTxtf.setToolTipText(properties.getProperty("enterUser"));
		inputUserTxtf.setBorder(BorderFactory.createLineBorder(Color.decode("#00AC94")));
		add(inputUserTxtf, gbc);
		gbc.gridy = 4;
		inputPasswordTxtf = new JTextField();
		inputPasswordTxtf.setToolTipText(properties.getProperty("enterPassword"));
		inputPasswordTxtf.setBorder(BorderFactory.createLineBorder(Color.decode("#00AC94")));
		add(inputPasswordTxtf, gbc);
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(5, 20, 5, 20);
		agreeTermsCkB = new JCheckBox();
		agreeTermsCkB.setBackground(Color.decode("#FFFFFF"));
		agreeTermsCkB.setFocusable(false);
		agreeTermsCkB.setText(properties.getProperty("agreeTerms"));
		add(agreeTermsCkB, gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		createAccountbtn = new JButton();
		createAccountbtn.setBackground(Color.decode("#00AC94"));
		createAccountbtn.setForeground(Color.decode("#FFFFFF"));
		createAccountbtn.setText(properties.getProperty("createAccountBtn"));
		createAccountbtn.setActionCommand(Constants.CREATENEWACCOUNTBTN);
		createAccountbtn.addActionListener(control);
		add(createAccountbtn, gbc);
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel(), gbc);
	}

	public String getUserText() {
		return inputUserTxtf.getText();
	}

	public String getPasswordText() {
		return inputPasswordTxtf.getText();
	}
	
	public boolean selectedCheck() {
		return agreeTermsCkB.isSelected();
	}

	private void generateBasicGrid(GridBagConstraints c) {
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 1; i++) {
			c.gridx = i;
			add(new JLabel(), c);
		}
		for (int i = 0; i < 10; i++) {
			c.gridy = i;
			add(new JLabel(), c);
		}
	}
}

package view.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Constants.Constants;
import Control.Control;

public class LoginPanel extends JPanel{
	private static final long serialVersionUID = -5852681464406432517L;
	
	private JLabel loginLbl;
	private JTextField userJtf;
	private JPasswordField passwordJtf;
	private JButton loginBtn;
	private JButton changeToWeb;
	private GridBagConstraints gbc;
	
	public LoginPanel(Control control, Properties properties) {
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
		loginLbl = new JLabel();
		loginLbl.setForeground(Color.decode("#F15B40"));
		loginLbl.setFont(new Font("Arial", 4 , 25));
		loginLbl.setText(properties.getProperty("login"));
		add(loginLbl, gbc);
		gbc.gridy = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel(), gbc);
		gbc.gridy = 3;
		userJtf = new JTextField();
		userJtf.setToolTipText(properties.getProperty("enterUser"));
		userJtf.setBorder(BorderFactory.createLineBorder(Color.decode("#00AC94")));
		add(userJtf, gbc);
		gbc.gridy = 4;
		passwordJtf = new JPasswordField();
		passwordJtf.setToolTipText(properties.getProperty("enterPassword"));
		passwordJtf.setBorder(BorderFactory.createLineBorder(Color.decode("#00AC94")));
		add(passwordJtf, gbc);
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(5, 20, 5, 20);
		loginBtn = new JButton();
		loginBtn.setBackground(Color.decode("#00AC94"));
		loginBtn.setForeground(Color.decode("#FFFFFF"));
		loginBtn.setText(properties.getProperty("loginbtn"));
		loginBtn.setActionCommand(Constants.LOGINBTN);
		loginBtn.addActionListener(control);
		add(loginBtn, gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel(),gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		changeToWeb = new JButton();
		changeToWeb.setBackground(Color.decode("#00AC94"));
		changeToWeb.setForeground(Color.decode("#FFFFFF"));
		changeToWeb.setText(properties.getProperty("changeToWeb"));
		changeToWeb.setActionCommand(Constants.CHANGETOWEBBTN);
		changeToWeb.addActionListener(control);
		add(changeToWeb, gbc);
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel(),gbc);
	}
	
	public String getUsernameText() {
		return userJtf.getText();
	}
	
	public void cleanTextFields() {
		userJtf.setText("");
		passwordJtf.setText("");
	}
	
	public String getPasswordText() {
		char[] password = passwordJtf.getPassword();
		return new String(password);
	}
	
	private void generateBasicGrid(GridBagConstraints c){
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

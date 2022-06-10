package view.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.Events;

public class LoginPanel extends JPanel{
	private static final String CHANGE_HOST = "Change Host";

	private static final long serialVersionUID = -5852681464406432517L;

	private static final String HOST = "Host";
	private static final String LOG_IN = "Log in";
	private static final String PASSWORD = "Password";
	private static final String USER = "User";
	private static final String FOREGROUND = "#F15B40";
	private static final String WHITE_COLOR = "#FFFFFF";
	private static final String BORDER_COLOR = "#00AC94";
	private static final String ENTER_PASSWORD = "Enter Password";
	private static final String ENTER_USER = "Enter User";
	private static final String LOGIN = "LOGIN";
	
	private JLabel loginLbl;
	private JTextField userJtf;
	private JPasswordField passwordJtf;
	private JButton loginBtn, changeHostBtn;
	private JTextField changeHost;
	private GridBagConstraints gbc;
	
	public LoginPanel(ActionListener control) {
		setBackground(Color.decode(WHITE_COLOR));
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
		loginLbl.setForeground(Color.decode(FOREGROUND));
		loginLbl.setFont(new Font("Arial", 4 , 25));
		loginLbl.setText(LOGIN);
		add(loginLbl, gbc);
		gbc.gridy = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel(), gbc);
		gbc.gridy = 3;
		userJtf = new JTextField();
		userJtf.setToolTipText(ENTER_USER);
		userJtf.setBorder(BorderFactory.createTitledBorder(USER));
		add(userJtf, gbc);
		gbc.gridy = 4;
		passwordJtf = new JPasswordField();
		passwordJtf.setToolTipText(ENTER_PASSWORD);
		passwordJtf.setBorder(BorderFactory.createTitledBorder(PASSWORD));
		add(passwordJtf, gbc);
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(5, 20, 5, 20);
		changeHost = new JTextField();
		changeHost.setBorder(BorderFactory.createTitledBorder(HOST));
		add(changeHost, gbc);
		gbc.gridx = 2;
		changeHostBtn = new JButton(CHANGE_HOST);
		changeHostBtn.setBackground(Color.decode(BORDER_COLOR));
		changeHostBtn.setForeground(Color.decode(WHITE_COLOR));
		changeHostBtn.addActionListener(control);
		changeHostBtn.setActionCommand(Events.CHANGE_HOST.toString());
		changeHost.setPreferredSize(new Dimension(100, 30));
		add(changeHostBtn, gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel(),gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		loginBtn = new JButton();
		loginBtn.setBackground(Color.decode(BORDER_COLOR));
		loginBtn.setForeground(Color.decode(WHITE_COLOR));
		loginBtn.setText(LOG_IN);
		loginBtn.setActionCommand(Events.LOGIN.toString());
		loginBtn.addActionListener(control);
		add(loginBtn, gbc);
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
	
	public String getHost() {
		return changeHost.getText();
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

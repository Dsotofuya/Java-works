package view.createAccount;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Events;

public class CreateAccountPanel extends JPanel {
	private static final long serialVersionUID = -2195702808561044393L;

	private static final String CREATE_ACCOUNT2 = "Create Account";
	private static final String F15B40 = "#F15B40";
	private static final String ENTER_USER = "Enter User";
	private static final String USER = "User";
	private static final String ENTER_PASSWORD = "Enter Password";
	private static final String PASSWORD = "Password";
	private static final String _00AC94 = "#00AC94";
	private static final String FFFFFF = "#FFFFFF";
	private static final String CREATE_ACCOUNT = CREATE_ACCOUNT2;

	private GridBagConstraints gbc;
	private JLabel createAccountLbl;
	private JTextField inputUserTxtf;
	private JTextField inputPasswordTxtf;
	private JCheckBox agreeTermsCkB;
	private JButton createAccountbtn;

	public CreateAccountPanel(ActionListener control) {
		setBackground(Color.decode(FFFFFF));
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
		createAccountLbl.setForeground(Color.decode(F15B40));
		createAccountLbl.setFont(new Font("Arial", 4, 25));
		createAccountLbl.setText(CREATE_ACCOUNT2);
		add(createAccountLbl, gbc);
		gbc.gridy = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel(), gbc);
		gbc.gridy = 3;
		inputUserTxtf = new JTextField();
		inputUserTxtf.setToolTipText(ENTER_USER);
		inputUserTxtf.setBorder(BorderFactory.createTitledBorder(USER));
		add(inputUserTxtf, gbc);
		gbc.gridy = 4;
		inputPasswordTxtf = new JTextField();
		inputPasswordTxtf.setToolTipText(ENTER_PASSWORD);
		inputPasswordTxtf.setBorder(BorderFactory.createTitledBorder(PASSWORD));
		add(inputPasswordTxtf, gbc);
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(5, 20, 5, 20);
		agreeTermsCkB = new JCheckBox();
		agreeTermsCkB.setBackground(Color.decode(FFFFFF));
		agreeTermsCkB.setFocusable(false);
		agreeTermsCkB.setText("Agree Terms");
		add(agreeTermsCkB, gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		createAccountbtn = new JButton();
		createAccountbtn.setBackground(Color.decode(_00AC94));
		createAccountbtn.setForeground(Color.decode(FFFFFF));
		createAccountbtn.setText(CREATE_ACCOUNT);
		createAccountbtn.setActionCommand(Events.CONFIRM_REGISTER.toString());
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

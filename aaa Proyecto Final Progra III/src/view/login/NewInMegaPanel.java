package view.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Events;

public class NewInMegaPanel extends JPanel {
	private static final long serialVersionUID = 2569201590162967896L;

	private static final String BACKGROUND_COLOR = "#EFF0F1";
	private static final String FOREGROUND = "#00AC94";
	
	private JButton createAccount;
	private GridBagConstraints gbc;
	
	public NewInMegaPanel(ActionListener control) {
		setBackground(Color.decode(BACKGROUND_COLOR));
		setPreferredSize(new Dimension(400, 300));
		gbc = new GridBagConstraints();
		generateBasicGrid(gbc);
		setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridy = 0;
		gbc.gridx = 2;
		gbc.weighty =0;
		gbc.gridwidth = 1;
		createAccount = new JButton();
		createAccount.setForeground(Color.decode(FOREGROUND));
		createAccount.setBackground(Color.decode(BACKGROUND_COLOR));
		createAccount.setBorder(BorderFactory.createEmptyBorder());
		createAccount.setText("Create Account");
		createAccount.setActionCommand(Events.REGISTER.toString());
		createAccount.addActionListener(control);
		createAccount.setFocusable(false);
		add(createAccount, gbc);
		gbc.gridy = 3;
		gbc.weighty = 50;
		add(new JLabel(), gbc);
	}
	
	private void generateBasicGrid(GridBagConstraints c){
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 3; i++) {
			c.gridx = i;
			add(new JLabel(), c);
		} 
		for (int i = 0; i < 10; i++) {
			c.gridy = i;
			add(new JLabel(), c);
		}
	}
	
}

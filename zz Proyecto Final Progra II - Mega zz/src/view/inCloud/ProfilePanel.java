package view.inCloud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Constants.Constants;
import Control.Control;

public class ProfilePanel extends JPanel {
	private static final long serialVersionUID = 5965420500443440472L;
	
	private GridBagConstraints gbc;
	private JButton changeNameBtn;
	private JLabel userNameLbl;
	private JComboBox<String> changeLanguajeCb;
	private JProgressBar graphic;
	private JButton deleteAccount;
	private JButton logOut;
	private JTextField changeNametft;
	private Properties properties;
	
	public ProfilePanel(Control control, Properties properties) {
		this.properties = properties;
		setBackground(Color.decode("#FFFFFF"));
		gbc = new GridBagConstraints();
		generateBasicGrid(gbc);
		setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(20, 20, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		userNameLbl = new JLabel();
		userNameLbl.setFont(new Font("Arial", 1 , 22));
		userNameLbl.setBackground(Color.red);
		userNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLbl.setPreferredSize(new Dimension(150, 32));
		add(userNameLbl, gbc);
		gbc.insets = new Insets(10, 20, 0, 20);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		changeNameBtn = new JButton(properties.getProperty("editName"), new ImageIcon("src/data/images/editImageIcon.png"));
		changeNameBtn.setHorizontalAlignment(SwingConstants.LEFT);
		changeNameBtn.setFocusable(false);
		changeNameBtn.setBackground(Color.decode("#00AC94"));
		changeNameBtn.setForeground(Color.decode("#FFFFFF"));
		changeNameBtn.setActionCommand(Constants.CHANGENAMEBTN);
		changeNameBtn.addActionListener(control);
		add(changeNameBtn, gbc);
		gbc.insets = new Insets(20, 20, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		changeLanguajeCb = new JComboBox<>();
		changeLanguajeCb.addItem(properties.getProperty("Spanish"));
		changeLanguajeCb.addItem(properties.getProperty("English"));
		changeLanguajeCb.addItem(properties.getProperty("Portuguese"));
		changeLanguajeCb.setActionCommand(Constants.LANGUAJESELECTED);
		changeLanguajeCb.addActionListener(control);
		add(changeLanguajeCb, gbc);
		gbc.insets = new Insets(10, 20, 0, 20);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		changeNameBtn = new JButton(properties.getProperty("editPassword"), new ImageIcon("src/data/images/editImageIcon.png")); 
		changeNameBtn.setHorizontalAlignment(SwingConstants.LEFT);
		changeNameBtn.setFocusable(false);
		changeNameBtn.setBackground(Color.decode("#00AC94"));
		changeNameBtn.setForeground(Color.decode("#FFFFFF"));
		changeNameBtn.setActionCommand(Constants.CHANGEPASSWORDBTN);
		changeNameBtn.addActionListener(control);
		add(changeNameBtn, gbc);
		gbc.insets = new Insets(20, 10, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		graphic = new JProgressBar(0, 10000);
		graphic.setPreferredSize(new Dimension(380, 30));
		graphic.setForeground(Color.decode("#00AC94"));
		add(graphic, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(30, 20, 0, 0);
		deleteAccount = new JButton(properties.getProperty("deleteAccount")); 
		deleteAccount.setFocusable(false);
		deleteAccount.setBackground(Color.decode("#F15B40"));
		deleteAccount.setForeground(Color.decode("#FFFFFF"));
		deleteAccount.setActionCommand(Constants.DELETEACCOUNT);
		deleteAccount.addActionListener(control);
		add(deleteAccount, gbc);
		gbc.gridx = 2;
		gbc.insets = new Insets(10, 10, 0, 20);
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		logOut = new JButton(properties.getProperty("logOut")); 
		logOut.setFocusable(false);
		logOut.setBackground(Color.decode("#FFFFFF"));
		logOut.setForeground(Color.decode("#383a3d"));
		logOut.setActionCommand(Constants.LOGOUT);
		logOut.addActionListener(control);
		add(logOut, gbc);
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 12;
		add(new JLabel(),gbc);
	}

	public String getSelectedLanguaje() {
		return (String) changeLanguajeCb.getSelectedItem();
	}
	
	public String getNewName() {
		return changeNametft.getText();
	}
	
	public void percentageUsed(int percentage) {
		Border empty = BorderFactory.createEmptyBorder();
		graphic.setBorder(BorderFactory.createTitledBorder(empty, properties.getProperty("spaceUsed") + ((int)percentage/100) + "%", TitledBorder.DEFAULT_POSITION,
				TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 13), Color.BLACK));
		graphic.setValue(percentage);
		repaint();
	}
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	public void setUserNameText(String name) {
		userNameLbl.setText(name);
	}
	
	private void generateBasicGrid(GridBagConstraints c){
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 12; i++) {
			c.gridx = i;
			add(new JLabel(), c);
		} 
		for (int i = 0; i < 12; i++) {
			c.gridy = i;
			add(new JLabel(), c);
		}
	}
	
}

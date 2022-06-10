package view.inCloud;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Constants.Constants;
import Control.Control;

public class FindBarPanel extends JPanel {
	private static final long serialVersionUID = 8358463779315903403L;

	private JLabel findTxtF;
	private JButton findBtn;
	private JButton optionsBtn;
	private JButton menuBtn;
	private JButton organizeBtn;
	private GridBagConstraints gbc;
	private Control control;
	private JButton backBtn;
	private Properties properties;

	public FindBarPanel(Control control, Properties properties) {
		this.properties = properties;
		this.control = control;
		gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		setBackground(Color.decode("#FFFFFF"));
		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		menuBtn = new JButton(new ImageIcon("src/data/images/menuIcon.png"));
		menuBtn.setActionCommand(Constants.MENUBTN);
		menuBtn.addActionListener(control);
		menuBtn.setFocusable(false);
		menuBtn.setBorder(BorderFactory.createEmptyBorder());
		add(menuBtn, gbc);
		findTxtF = new JLabel(properties.getProperty("myCloud"));
		findTxtF.setBackground(Color.decode("#FFFFFF"));
		findTxtF.setFocusable(false);
		findTxtF.setPreferredSize(new Dimension(150, 30));
		findTxtF.setBorder(BorderFactory.createEmptyBorder());
		findTxtF.setFont(new Font("Arial", 1, 15));
		gbc.gridx = 2;
		gbc.gridwidth = 6;
		gbc.gridheight = 2;
		gbc.weightx = 10;
		gbc.weighty = 5;
		gbc.insets = new Insets(10, 30, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(findTxtF, gbc);
		findBtn = new JButton(new ImageIcon("src/data/images/blackLenIcon.png"));
		findBtn.setFocusable(false);
		findBtn.setBorder(BorderFactory.createEmptyBorder());
		findBtn.setBorderPainted(false);
		gbc.gridx = 8;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		add(findBtn, gbc);
		organizeBtn = new JButton(new ImageIcon("src/data/images/gridIcon.png"));
		organizeBtn.setFocusable(false);
		organizeBtn.setBorder(BorderFactory.createEmptyBorder());
		gbc.gridx = 8;
		gbc.gridx = 9;
		add(organizeBtn, gbc);
		optionsBtn = new JButton(new ImageIcon("src/data/images/optionIcon.png"));
		optionsBtn.setActionCommand(Constants.OPTIONSBTN);
		optionsBtn.addActionListener(control);
		optionsBtn.setFocusable(false);
		optionsBtn.setBorder(BorderFactory.createEmptyBorder());
		gbc.gridx = 8;
		gbc.gridx = 10;
		add(optionsBtn, gbc);
	}

	public void showButtonBack() {
		menuBtn.setVisible(false);
		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		backBtn = new JButton(new ImageIcon("src/data/images/menuIcon.png"));
		backBtn.setActionCommand(Constants.BACKBTN);
		backBtn.addActionListener(control);
		backBtn.setFocusable(false);
		backBtn.setBorder(BorderFactory.createEmptyBorder());
		add(backBtn, gbc);
	}
	
	public void showMenuButton() {
		menuBtn.setVisible(true);
		backBtn.setVisible(false);
	}
	
	public void showMenu() {
		JPopupMenu menu = new JPopupMenu();
		menu.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		JMenuItem addfolder = new JMenuItem(properties.getProperty("addFolder"));
		addfolder.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		addfolder.setActionCommand(Constants.ADDFOLDER);
		addfolder.addActionListener(control);
		menu.add(addfolder);
		menu.show(optionsBtn, optionsBtn.getWidth() / optionsBtn.getWidth(), optionsBtn.getHeight());
		menu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}

	public void setText(String text) {
		findTxtF.setText(text);
	}
}

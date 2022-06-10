package view.inCloud;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import Constants.Constants;
import Control.Control;

public class ComponentsGenerator extends JPanel {
	private static final long serialVersionUID = 522235414389256652L;
	private GridBagConstraints gbc;
	private Control control;
	private JButton newArchive;
	private JButton optionsNewArchive;
	private Properties properties;

	public ComponentsGenerator(Control control, Properties properties) {
		this.properties = properties;
		this.control = control;
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		generateBasicGrid(gbc);
		this.setBackground(Color.white);
	}

	public void addArchive(String name, String typeArchive) {
		setName(name);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 8;
		gbc.gridheight = 1;
		gbc.weightx = 200;
		newArchive = new JButton();
		newArchive.setName(name);
		newArchive.setText(name);
		newArchive.setFocusable(false);
		newArchive.setBorder(BorderFactory.createEmptyBorder());
		newArchive.setBackground(Color.white);
		newArchive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showMenu();
			}
		});
		if (typeArchive.equalsIgnoreCase("C")) {
			newArchive.setIcon(new ImageIcon("src/data/images/colorDirIcon.png"));
		} else if (typeArchive.equalsIgnoreCase("A")) {
			newArchive.setIcon(new ImageIcon("src/data/images/archiveIcon.png"));
		}
		newArchive.setHorizontalAlignment(SwingConstants.LEFT);
		add(newArchive, gbc);
		gbc.weightx = 0;
		gbc.gridx = 9;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		optionsNewArchive = new JButton(new ImageIcon("src/data/images/optionIcon.png"));
		optionsNewArchive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showMenu();
			}
		});
		optionsNewArchive.setBackground(Color.white);
		optionsNewArchive.setFocusable(false);
		optionsNewArchive.setBorder(BorderFactory.createEmptyBorder());
		add(optionsNewArchive, gbc);
	}
	
	public void showMenu() {
		JPopupMenu menu = new JPopupMenu();
		menu.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		JMenuItem renameFolder = new JMenuItem(properties.getProperty("renameFolder"));
		renameFolder.setName(newArchive.getName());
		renameFolder.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		renameFolder.setActionCommand(Constants.RENAMEFOLDER);
		renameFolder.addActionListener(control);
		menu.add(renameFolder);
		JMenuItem deletefolder = new JMenuItem(properties.getProperty("deleteFolder"));
		deletefolder.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);;
		deletefolder.setName(newArchive.getName());
		deletefolder.setActionCommand(Constants.DELETEFOLDER);
		deletefolder.addActionListener(control);
		menu.add(deletefolder);
		menu.show(optionsNewArchive, optionsNewArchive.getWidth() / optionsNewArchive.getWidth(), optionsNewArchive.getHeight());
		menu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}
	
	private void generateBasicGrid(GridBagConstraints c) {
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 10; i++) {
			c.gridx = i;
			add(new JLabel(), c);
		}
		for (int i = 0; i < 10; i++) {
			c.gridy = i;
			add(new JLabel(), c);
		}
	}
}

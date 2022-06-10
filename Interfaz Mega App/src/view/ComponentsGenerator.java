package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//IMPLEMENTAR JFILECHOOSER

public class ComponentsGenerator extends JPanel {
	private static final long serialVersionUID = 522235414389256652L;
	private GridBagConstraints gbc;
	
	public ComponentsGenerator() {
	setLayout(new GridBagLayout());
	gbc = new GridBagConstraints();
	
	}
	
	public void addArchive(String name, String typeArchive) {
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.gridy = 1;
	gbc.gridx = 1;
	gbc.gridwidth = 7;
	gbc.gridheight = 1;
	gbc.fill = GridBagConstraints.BOTH;
	JButton newArchive = new JButton();
	newArchive.setText(name);
	newArchive.setFocusable(false);
	newArchive.setBorder(BorderFactory.createEmptyBorder());
	newArchive.setBackground(Color.decode("#FAFAFA"));
		if (typeArchive.equalsIgnoreCase("Carpeta")) {
			newArchive.setIcon(new ImageIcon("src/zData/colorDirIcon.png"));
			
		} else if (typeArchive.equalsIgnoreCase("Archivo Sin imagen")) {
			newArchive.setIcon(new ImageIcon("src/zData/blacLenIcon.png"));
		} else if (typeArchive.equalsIgnoreCase("Archivo con imagen")) {
			newArchive.setIcon(new ImageIcon("ruta      xdxdxd "));
		}
	add(newArchive, gbc);
	gbc.gridx = 8;
	gbc.gridwidth = GridBagConstraints.REMAINDER;
	JButton optionsNewArchive = new JButton(new ImageIcon("src/zData/optionIcon.png"));
	optionsNewArchive.setBackground(Color.decode("#FAFAFA"));
	optionsNewArchive.setFocusable(false);
	optionsNewArchive.setBorder(BorderFactory.createEmptyBorder());
	add(optionsNewArchive, gbc);
	}
}

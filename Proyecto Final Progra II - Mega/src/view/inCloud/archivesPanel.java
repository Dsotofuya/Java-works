package view.inCloud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Control.Control;

public class archivesPanel extends JPanel {
	private static final long serialVersionUID = 3259932329768191119L;

	private foldersAndArchivesPanel foldersAndArchivesPanel;
	private GridBagConstraints gbc;

	public archivesPanel(Control control, Properties properties) {
		this.setPreferredSize(new Dimension(400, 500));
		this.setBackground(Color.decode("#D90007"));
		gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		generateBasicGrid(gbc);
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.weightx = 500;
		gbc.weighty = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		foldersAndArchivesPanel = new foldersAndArchivesPanel(control, properties);
		JScrollPane scroll = new JScrollPane(foldersAndArchivesPanel);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		add(scroll, gbc);
	}

	public void addFolder(String name) {
		foldersAndArchivesPanel.addFolder(name);
	}

	public void addArchive(String name) {
		foldersAndArchivesPanel.addArchive(name);
	}
	
	public void clean() {
		foldersAndArchivesPanel.removeAll();
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

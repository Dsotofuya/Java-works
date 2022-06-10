package view.inCloud;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Control.Control;

public class foldersAndArchivesPanel extends JPanel {
	private static final long serialVersionUID = -422431295992874324L;

	private JLabel supp;
	private GridBagConstraints gbc;
	private int count;
	private Control control;
	private ComponentsGenerator generator;
	private Properties properties;

	public foldersAndArchivesPanel(Control control, Properties properties) {
		this.properties = properties;
		this.control = control;
		count = 0;
		this.setBackground(Color.white);
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		Border empty = BorderFactory.createEmptyBorder();
		setBorder(BorderFactory.createTitledBorder(empty, "Carpetas", TitledBorder.DEFAULT_POSITION,
				TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 13), Color.BLACK));
		generateBasicGrid(gbc);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 0;
		gbc.weighty = 0;
		gbc.gridy = count;
		gbc.weighty = 1;
		add(supp = new JLabel(), gbc);
	}
	
	public void addFolder(String folderName) {
		remove(supp);
		count++;
		gbc.weighty = 0;
		gbc.gridy = count;
		count++;
		generator = new ComponentsGenerator(control,properties);
		generator.addArchive(folderName, "C");
		add(generator, gbc);
		gbc.gridy = count;
		gbc.weighty = 1;
		add(supp = new JLabel(), gbc);
		revalidate();
		repaint();
	}
	
	public void addArchive(String archiveName) {
		remove(supp);
		count++;
		gbc.weighty = 0;
		gbc.gridy = count;
		count++;
		generator = new ComponentsGenerator(control,properties);
		generator.addArchive(archiveName, "A");
		add(generator, gbc);
		gbc.gridy = count;
		gbc.weighty = 1;
		add(supp = new JLabel(), gbc);
		revalidate();
		repaint();
	}

	private void generateBasicGrid(GridBagConstraints c) {
		c.weightx = 1;
		c.gridheight = 1;
		for (int i = 0; i < 1; i++) {
			c.gridx = i;
			add(new JLabel(), c);
		}
		for (int i = 0; i < 5; i++) {
			c.gridy = i;
			add(new JLabel(), c);
		}
	}
}

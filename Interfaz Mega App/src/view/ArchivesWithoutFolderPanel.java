package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ArchivesWithoutFolderPanel extends JPanel{
	private static final long serialVersionUID = 7661117605075473215L;
	private GridBagConstraints gbc;
	
	public ArchivesWithoutFolderPanel() {
		Border empty = BorderFactory.createEmptyBorder();
		setBorder(BorderFactory.createTitledBorder(empty, "Archivos", TitledBorder.DEFAULT_POSITION,
				TitledBorder.DEFAULT_POSITION, new Font("Arial", 4, 12), Color.BLACK));
		setLayout(new GridBagLayout());
		
	}
}

package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class FoldersPanel extends JPanel {
	private static final long serialVersionUID = -422431295992874324L;

	private ComponentsGenerator generator; 
	private GridBagConstraints gbc;
	
	public FoldersPanel() {
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		Border empty = BorderFactory.createEmptyBorder();
		setBorder(BorderFactory.createTitledBorder(empty, "Carpetas", TitledBorder.DEFAULT_POSITION,
				TitledBorder.DEFAULT_POSITION, new Font("Arial", 4, 12), Color.BLACK));
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		generator = new ComponentsGenerator();
		generator.addArchive("MEGAsync", "Carpeta");
		generator.addArchive("My Chat Files", "Carpeta");
		add(generator, gbc);
	
	}
}

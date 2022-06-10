package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class CloudPanel extends JPanel {
	private static final long serialVersionUID = 3259932329768191119L;

	private FoldersPanel foldersPanel;
	private ArchivesWithoutFolderPanel archivesPanel;
	private GridBagConstraints gbc;
	
	public CloudPanel() {
		gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		foldersPanel = new FoldersPanel();
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		//		gbc.gridwidth = GridBagConstraints.REMAINDER;
//		gbc.gridx = 1;
		add(foldersPanel);
		archivesPanel = new ArchivesWithoutFolderPanel();
		add(archivesPanel);
	}
}

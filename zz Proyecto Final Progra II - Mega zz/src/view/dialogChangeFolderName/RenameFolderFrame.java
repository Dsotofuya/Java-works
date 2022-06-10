package view.dialogChangeFolderName;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Control.Control;

public class RenameFolderFrame extends JFrame {
	private static final long serialVersionUID = 6551319239209056558L;

	private JTextField inputNewArchiveName;
	private AcceptCancelButtonsArchive aceptCancel;
	
	public RenameFolderFrame(Control control, Properties properties) {
		setLayout(new BorderLayout());
		setSize(new Dimension(200, 75));
		setIconImage(new ImageIcon("src/data/images/MegaIcon.png").getImage());
		setResizable(false);
		setUndecorated(true);
		inputNewArchiveName = new JTextField();
		add(inputNewArchiveName, BorderLayout.CENTER);
		aceptCancel = new AcceptCancelButtonsArchive(control, properties);
		add(aceptCancel, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setVisible(false);
	}
	
	public String getNewArchiveName() {
		return inputNewArchiveName.getText();
	}
	
	public void clean() {
		inputNewArchiveName.setText("");
	}
}

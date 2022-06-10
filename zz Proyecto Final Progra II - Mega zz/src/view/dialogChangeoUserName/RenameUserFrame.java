package view.dialogChangeoUserName;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Control.Control;

public class RenameUserFrame extends JFrame {
	private static final long serialVersionUID = 6551319239209056558L;

	private JTextField inputNewUserName;
	private AcceptCancelButtonsUser aceptCancel;
	
	public RenameUserFrame(Control control, Properties properties) {
		setLayout(new BorderLayout());
		setSize(new Dimension(200, 75));
		setIconImage(new ImageIcon("src/data/images/MegaIcon.png").getImage());
		setUndecorated(true);
		setResizable(false);
		inputNewUserName = new JTextField();
		add(inputNewUserName, BorderLayout.CENTER);
		aceptCancel = new AcceptCancelButtonsUser(control, properties);
		add(aceptCancel, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setVisible(false);
	}
	
	public String getNewUserName() {
		return inputNewUserName.getText();
	}
	
	public void clean() {
		inputNewUserName.setText("");
	}
}

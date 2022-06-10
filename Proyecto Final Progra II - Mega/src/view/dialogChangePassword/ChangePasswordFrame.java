package view.dialogChangePassword;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Control.Control;

public class ChangePasswordFrame extends JFrame {
	private static final long serialVersionUID = 6551319239209056558L;

	private JTextField inputNewPassword;
	private AcceptCancelButtonsPassword aceptCancel;
	
	public ChangePasswordFrame(Control control, Properties properties) {
		setLayout(new BorderLayout());
		setSize(new Dimension(200, 75));
		setIconImage(new ImageIcon("src/data/images/MegaIcon.png").getImage());
		setUndecorated(true);
		setResizable(false);
		inputNewPassword = new JTextField();
		add(inputNewPassword, BorderLayout.CENTER);
		aceptCancel = new AcceptCancelButtonsPassword(control, properties);
		add(aceptCancel, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setVisible(false);
	}
	
	public String getNewPassword() {
		return inputNewPassword.getText();
	}
	
	public void clean() {
		inputNewPassword.setText("");
	}
}

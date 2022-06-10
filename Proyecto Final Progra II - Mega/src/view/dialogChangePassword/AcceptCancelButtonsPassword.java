package view.dialogChangePassword;

import java.awt.Color;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JPanel;

import Constants.Constants;
import Control.Control;

public class AcceptCancelButtonsPassword extends JPanel{
	private static final long serialVersionUID = -2402703161958207184L;
	
	private JButton aceptBtn;
	private JButton cancelBtn;
	
	public AcceptCancelButtonsPassword(Control control, Properties properties) {
		aceptBtn = new JButton(properties.getProperty("accept"));
		aceptBtn.setBackground(Color.decode("#00AC94"));
		aceptBtn.setForeground(Color.decode("#FFFFFF"));
		aceptBtn.setActionCommand(Constants.ACCEPTCHANGEPASSWORD);
		aceptBtn.addActionListener(control);
		add(aceptBtn);
		cancelBtn = new JButton(properties.getProperty("cancel"));
		cancelBtn.setBackground(Color.decode("#00AC94"));
		cancelBtn.setForeground(Color.decode("#FFFFFF"));
		cancelBtn.setActionCommand(Constants.CANCELCHANGEPASSWORD);
		cancelBtn.addActionListener(control);
		add(cancelBtn);
	}
}

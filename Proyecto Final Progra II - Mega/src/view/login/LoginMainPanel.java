package view.login;

import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.JPanel;

import Control.Control;

public class LoginMainPanel extends JPanel {
	private static final long serialVersionUID = -1363104765089826680L;
	
	private LoginPanel loginPanel;
	private NewInMegaPanel newInMegaPanel;
	public LoginMainPanel(Control control, Properties properties) {
		setSize(400, 650);
		setLayout(new GridLayout(2,1));
		loginPanel = new LoginPanel(control, properties);
		add(loginPanel);
		newInMegaPanel = new NewInMegaPanel(control, properties);
		add(newInMegaPanel);
	}
	
	public void cleanTextFields() {
		loginPanel.cleanTextFields();
	}
	
	public String getUsernameText() {
		return loginPanel.getUsernameText();
	}
	
	public String getPasswordText() {
		return loginPanel.getPasswordText();
	}
}

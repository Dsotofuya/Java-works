package view.login;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class LoginMainPanel extends JPanel {
	private static final long serialVersionUID = -1363104765089826680L;
	
	private LoginPanel loginPanel;
	private NewInMegaPanel newInAppPanel;
	
	public LoginMainPanel(ActionListener control) {
		setSize(400, 650);
		setLayout(new GridLayout(2,1));
		loginPanel = new LoginPanel(control);
		add(loginPanel);
		newInAppPanel = new NewInMegaPanel(control);
		add(newInAppPanel);
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
	
	public String getHostText() {
		return loginPanel.getHost();
	}
}

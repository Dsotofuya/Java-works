package view.createAccount;

import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.JPanel;

import Control.Control;

public class CreateAccountMainPanel extends JPanel {
	private static final long serialVersionUID = -2195702808561044393L;

	private CreateAccountPanel createAccountPanel;
	private ToLoginPanel toLoginPanel;

	public CreateAccountMainPanel(Control control, Properties properties) {
		setSize(400, 650);
		setLayout(new GridLayout(2, 1));
		createAccountPanel = new CreateAccountPanel(control, properties);
		add(createAccountPanel);
		toLoginPanel = new ToLoginPanel(control, properties);
		add(toLoginPanel);
	}

	public String getUsernameText() {
		return createAccountPanel.getUserText();
	}

	public String getPasswordText() {
		return createAccountPanel.getPasswordText();
	}
	
	public boolean selectedCheck() {
		return createAccountPanel.selectedCheck();
	}

}

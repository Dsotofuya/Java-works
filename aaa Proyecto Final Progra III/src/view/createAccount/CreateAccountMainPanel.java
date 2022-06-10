package view.createAccount;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CreateAccountMainPanel extends JPanel {
	private static final long serialVersionUID = -2195702808561044393L;

	private CreateAccountPanel createAccountPanel;
	private ToLoginPanel toLoginPanel;

	public CreateAccountMainPanel(ActionListener control) {
		setSize(400, 650);
		setLayout(new GridLayout(2, 1));
		createAccountPanel = new CreateAccountPanel(control);
		add(createAccountPanel);
		toLoginPanel = new ToLoginPanel(control);
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

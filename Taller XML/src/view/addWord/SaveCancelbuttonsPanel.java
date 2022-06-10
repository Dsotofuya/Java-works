package view.addWord;

import javax.swing.JButton;
import javax.swing.JPanel;

import Constants.Constants;
import Control.Controller;

public class SaveCancelbuttonsPanel extends JPanel {
	private static final long serialVersionUID = 630253622210802407L;

	private JButton save;
	private JButton cancel;

	public SaveCancelbuttonsPanel(Controller control) {
		save = new JButton(Constants.SAVEBTN);
		save.setActionCommand(Constants.SAVE);
		save.addActionListener(control);
		add(save);
		cancel = new JButton(Constants.CANCELBTN);
		cancel.setActionCommand(Constants.CANCEL);
		cancel.addActionListener(control);
		add(cancel);
	}
}

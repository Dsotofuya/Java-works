package view.addSynonym;

import javax.swing.JButton;
import javax.swing.JPanel;

import Constants.Constants;
import Control.Controller;

public class SaveCancelbuttonsOfSynonymPanel extends JPanel {
	private static final long serialVersionUID = 630253622210802407L;

	private JButton save;
	private JButton cancel;

	public SaveCancelbuttonsOfSynonymPanel(Controller control) {
		save = new JButton(Constants.SAVEBTNSYNONYM);
		save.setActionCommand(Constants.SAVESYNONYM);
		save.addActionListener(control);
		add(save);
		cancel = new JButton(Constants.CANCELBTNSYNONYM);
		cancel.setActionCommand(Constants.CANCELSYNONYM);
		cancel.addActionListener(control);
		add(cancel);
	}
}

package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Hardware;
import View.FrameHardware;
import View.Dialogs.DialogAddHardware;

public class Controller implements ActionListener {

	private DialogAddHardware addHardware;
	private FrameHardware window;
	private HardwareController hardwareController;
	
	
	public Controller() {
	addHardware = new DialogAddHardware(window, this);
	window = new FrameHardware();
	hardwareController = new HardwareController();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case SHOW_DIALOG_HARDWARE:
			showDialogHardWare();
			break;
		case ADD: 
			addHardware();

		default:
			break;
		}
	}

	private void addHardware() {
		Hardware hardware = addHardware.getHardware();
		hardwareController.addHardware(hardware);
//		metodo de refrescar tabla
		addHardware.setVisible(false);
	}

	private void showDialogHardWare() {
		addHardware.setVisible(true);
	}

	public static void main(String[] args) {
		new Controller();
	}
}

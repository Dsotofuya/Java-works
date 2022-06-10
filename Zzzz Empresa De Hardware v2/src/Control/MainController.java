package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.ShutdownChannelGroupException;

import Model.Hardware;
import Model.ManagerHardware;
import Model.Dao.DaoHardware;
import View.WindowFrame;
import View.Dialogs.DialogAddHardware;

public class MainController implements ActionListener {

	private WindowFrame window;
	private DialogAddHardware dialogAddHardware;
	private DaoHardware daoHardware;
	private ManagerHardware managerHardware;

	public MainController() {
		window = new WindowFrame(this);
		dialogAddHardware = new DialogAddHardware(window, this);
		managerHardware = new ManagerHardware();
		daoHardware = new DaoHardware();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (Events.valueOf(e.getActionCommand())) {
		case SHOW_DIALOG_ADD:
			showAddDialog();
			break;
		case ADD:
			addHardware();
		default:
			break;
		}

	}

	private void showAddDialog() {
		dialogAddHardware.setVisible(true);
	}

	private void addHardware() {
		Hardware hardware = dialogAddHardware.getHardware();
		managerHardware.addHardware(hardware);
		// metodo refrescar tabla
		dialogAddHardware.setVisible(false);
	}

	public static void main(String[] args) {
		new MainController();
	}
}

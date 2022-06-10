package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.ManagerHardware;
import Model.Dao.DaoHardware;
import View.WindowFrame;
import View.Dialogs.DialogAddHardware;
import View.Dialogs.DialogDelete;

public class ControllerMain implements ActionListener {

	private WindowFrame windowFrame;
	private ManagerHardware managerHardware;
	private DialogAddHardware dialogAddHardware;
	private DialogDelete dialogDelete;
	private DaoHardware daoHardware;

	public ControllerMain() {
		managerHardware = new ManagerHardware();
		daoHardware = new DaoHardware();
		windowFrame = new WindowFrame(this, "INGLES");
		dialogAddHardware = new DialogAddHardware(windowFrame, this);
		dialogDelete = new DialogDelete(windowFrame, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (Events.valueOf(e.getActionCommand())) {
		case SHOW_DIALOG_ADD:
			showDialogAdd();
			break;
		case ADD:
			addHardware();
			break;
		case SHOW_DELETE_DIALOG:
			showDialogDelete();
			break;
		case DELETE:
			deleteHardware();
			break;
		case ESPANIOL:
			selectLenguaje("ESPA�OL");
			break;
		case PORTUGUES:
			selectLenguaje("PORTUGUES");
			break;
		case FRANCES:
			selectLenguaje("FRANCES");
			break;
		case CHINO:
			selectLenguaje("CHINO");
			break;
		case INGLES:
			selectLenguaje("INGLES");
			break;
		case EXIT:
			windowFrame.dispose();
			break;
		case EXPORT:
			exportArchive();
			break;
		case IMPORT:
			importArchive();
			break;
		default:
			break;
		}

	}



	private void importArchive() {
		daoHardware.readArchive();
		
	}

	private void exportArchive() {
		// TODO Auto-generated method stub
		
	}

	private void selectLenguaje(String lenguaje) {
		windowFrame = new WindowFrame(this, lenguaje);
		
	}

	private void showDialogDelete() {
		dialogDelete.clearId();
		dialogDelete.setVisible(true);
	}
	
	private void deleteHardware() {
		try {
			
			int x = Integer.parseInt(dialogDelete.getId());
			managerHardware.deleteHardware(x);
			windowFrame.getTable().fillTableDelete(managerHardware.getHardwareList());
		} catch (Exception e) {
//			JOptionPane.showMessageDialog(dialogAddHardware, "No existe esta id", "Error", JOptionPane.WARNING_MESSAGE);
		}
		dialogDelete.setVisible(false);
	}

	private void addHardware() {
		try {
			managerHardware.addHardware(ManagerHardware.createHardware(dialogAddHardware.getName(),
										dialogAddHardware.getDescription(), dialogAddHardware.getQuantity(),
										dialogAddHardware.getPrice()));
			windowFrame.getTable().fillTable(managerHardware.getHardwareList());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(dialogAddHardware, "No pudo crear el objeto", "Error", JOptionPane.WARNING_MESSAGE);
			showDialogAdd();
			e.printStackTrace();
		}
		dialogAddHardware.setVisible(false);
	}

	private void showDialogAdd() {
		dialogAddHardware.clearDialog();
		dialogAddHardware.setVisible(true);

	}
	
	public static void main(String[] args) {
		new ControllerMain();
	}

}

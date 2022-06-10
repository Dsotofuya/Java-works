package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

import Model.Ciudad;
import Model.ManagerCiudad;
import Model.Dao.JsonDao;
import View.WindowFrame;
import View.Dialogs.DialogAddCiudad;

public class MainController implements ActionListener {

	private WindowFrame windowFrame;
	private ManagerCiudad managerCiudad;
	private DialogAddCiudad dialogAddCiudad;
	@SuppressWarnings("unused")
	private JsonDao dao;

	public MainController() {
		managerCiudad = new ManagerCiudad();
		dao = new JsonDao();
		windowFrame = new WindowFrame(this);
		dialogAddCiudad = new DialogAddCiudad(windowFrame, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (Events.valueOf(e.getActionCommand())) {
		case SHOW_DIALOG_ADD:
			showDialogAdd();
			break;
		case ADD:
			addCuidad();
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
		windowFrame.getTable().fillTable((ArrayList<Ciudad>) managerCiudad.cargarCiudades());
		
	}

	private void exportArchive() {
		managerCiudad.guardarCiudades();
		JOptionPane.showMessageDialog(windowFrame, "Archivo guardado en D//:Ciudades.json", "guardado", 0, null);
	}
	
	private void addCuidad() {
		try {
			managerCiudad.addCuidad(ManagerCiudad.createCiudad(dialogAddCiudad.getName(),
										dialogAddCiudad.getLatitud(), dialogAddCiudad.getLongitud(),
										dialogAddCiudad.getTemperatura(), dialogAddCiudad.getPoblacion()));
			windowFrame.getTable().fillTable((ArrayList<Ciudad>) managerCiudad.getListaCiudades());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(dialogAddCiudad, "No pudo crear el objeto", "Error", JOptionPane.WARNING_MESSAGE);
			showDialogAdd();
			e.printStackTrace();
		}
		dialogAddCiudad.setVisible(false);
	}

	private void showDialogAdd() {
		dialogAddCiudad.clearDialog();
		dialogAddCiudad.setVisible(true);

	}
	
	public static void main(String[] args) {
		new MainController();
	}

}

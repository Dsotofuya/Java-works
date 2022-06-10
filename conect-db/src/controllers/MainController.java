package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import connection.Connect;
import controllers.Event;
import models.Lugar;
import models.ManagerLugares;
import models.TipoLugar;
import views.AddPlaceDialog;
import views.MainFrame;

public class MainController implements ActionListener{
	
	private Connect connect;
	private ManagerLugares  managerLugares;
	private AddPlaceDialog addPlaceDialog;
	private MainFrame mainFrame;
	
	public MainController() {
		try {
			connect = new Connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	managerLugares = new ManagerLugares();
	addPlaceDialog = new AddPlaceDialog(this);
	mainFrame = new MainFrame(this);
	init();
	}

	private void init() {
		Object[] atributes = {"IdLugar", "ubicacion", "nombreLugar", "nacionalidad", "tipolugar"};
		managerLugares.setPlacesList(connect.test());
		mainFrame.getMainPanel().getDefaultTableModel().setDataVector(
				managerLugares.generateObjectsFromList(),
				atributes
				);
		mainFrame.getMainPanel().getjTable().setModel(
				mainFrame.getMainPanel().getDefaultTableModel()
				);
		addPlaceDialog.getSpinnerNumberModel().setMaximum(managerLugares.newPlaceId() - 1);
		addPlaceDialog.getUbicationSpinner().setModel(addPlaceDialog.getSpinnerNumberModel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Event.valueOf(e.getActionCommand())) {
		case SHOW_ADD_PLACE_DIALOG:
			showAddPlaceDialog();
			break;
		case ADD_PLACE:
			addPlace();
			break;
		case REMOVE_PLACE:
			removePlace();
			break;
		case EDIT_PLACE:
			editPlace();
			break;
		}
	}
	
	private void showAddPlaceDialog() {
		addPlaceDialog.setVisible(true);
	}

	private void addPlace() {
		Object[] atributes = {"ubicacion", "nombreLugar", "nacionalidad", "tipolugar"};
		managerLugares.addLugar(new Lugar(
				managerLugares.newPlaceId(),
				(int)addPlaceDialog.getUbicationSpinner().getValue(),
				addPlaceDialog.getPlaceNameTextField().getText(),
				addPlaceDialog.getDemonymTextField().getText(),
				(TipoLugar)addPlaceDialog.getPlaceTypeComboBox().getSelectedItem()
				));
		
		addPlaceDialog.getSpinnerNumberModel().setMaximum(managerLugares.newPlaceId() - 1);
		addPlaceDialog.getUbicationSpinner().setModel(addPlaceDialog.getSpinnerNumberModel());
		
		mainFrame.getMainPanel().getDefaultTableModel().setDataVector(
				managerLugares.generateObjectsFromList(),
				atributes
				);
		
		mainFrame.getMainPanel().getjTable().setModel(
				mainFrame.getMainPanel().getDefaultTableModel()
				);
		
		mainFrame.repaint();
		mainFrame.revalidate();
		
		try {
			connect.insert(new Lugar(
					managerLugares.newPlaceId(),
					(int)addPlaceDialog.getUbicationSpinner().getValue(),
					addPlaceDialog.getPlaceNameTextField().getText(),
					addPlaceDialog.getDemonymTextField().getText(),
					(TipoLugar)addPlaceDialog.getPlaceTypeComboBox().getSelectedItem()
					));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addPlaceDialog.setVisible(false);
	}

	private void removePlace() {
		// TODO Auto-generated method stub
		
	}

	private void editPlace() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new MainController();
	}

}
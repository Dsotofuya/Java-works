package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Connect;
import controllers.Event;
import models.Place;
import models.ManagerPlaces;
import models.TipoLugar;
import views.AddPlaceDialog;
import views.EditPlaceDialog;
import views.MainFrame;
import views.RemovePlaceDialog;

public class MainController implements ActionListener {

	private Connect connect;
	private ManagerPlaces managerLugares;
	private AddPlaceDialog addPlaceDialog;
	private RemovePlaceDialog removePlaceDialog;
	private EditPlaceDialog editPlaceDialog;
	private MainFrame mainFrame;

	public MainController() throws SQLException {
		try {
			connect = new Connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		editPlaceDialog = new EditPlaceDialog(this);
		managerLugares = new ManagerPlaces();
		addPlaceDialog = new AddPlaceDialog(this);
		removePlaceDialog = new RemovePlaceDialog(this);
		mainFrame = new MainFrame(this);
		init();
	}

	private void init() {
		Object[] atributes = { "IdLugar", "ubicacion", "nombreLugar", "nacionalidad", "tipolugar" };
		mainFrame.getMainPanel().getDefaultTableModel().setDataVector(managerLugares.generateObjectsFromList(),
				atributes);
		mainFrame.getMainPanel().getjTable().setModel(mainFrame.getMainPanel().getDefaultTableModel());
		addPlaceDialog.getSpinnerNumberModel().setMaximum(managerLugares.newPlaceId()-1);
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
		case SHOW_REMOVE_PLACE:
			showDeletePlaceDialog();
			break;
		case REMOVE_PLACE:
			removePlace();
			break;
		case SHOW_EDIT_PLACE:
			showEditPlaceDialog();
			break;
		case EDIT_PLACE:
			editPlace();
			break;
		default:
			break;
		}
	}

	private void showDeletePlaceDialog() {
		removePlaceDialog.cleanComboBox();
		removePlaceDialog.setVisible(true);
		ArrayList<Integer> placesId = new ArrayList<>();
		for (Place place : managerLugares.getPlacesList()) {
			placesId.add(place.getIdLugar());
		}
		removePlaceDialog.fillBox(placesId);
	}

	private void showEditPlaceDialog() {
		editPlaceDialog.clean();
		editPlaceDialog.setVisible(true);
		ArrayList<Integer> placesId = new ArrayList<>();
		for (Place place : managerLugares.getPlacesList()) {
			placesId.add(place.getIdLugar());
		}
		editPlaceDialog.fillBox(placesId);
	}

	private void showAddPlaceDialog() {
		addPlaceDialog.clean();
		addPlaceDialog.setVisible(true);
	}

	private void addPlace() {
		managerLugares.addPlace(new Place(managerLugares.newPlaceId(),
				(int) addPlaceDialog.getUbicationSpinner().getValue(), addPlaceDialog.getPlaceNameTextField().getText(),
				addPlaceDialog.getDemonymTextField().getText(),
				(TipoLugar) addPlaceDialog.getPlaceTypeComboBox().getSelectedItem()));
		addPlaceDialog.getSpinnerNumberModel().setMaximum(managerLugares.newPlaceId()-1);
		addPlaceDialog.getUbicationSpinner().setModel(addPlaceDialog.getSpinnerNumberModel());
		connect.insert(new Place(managerLugares.newPlaceId(), (int) addPlaceDialog.getUbicationSpinner().getValue(),
				addPlaceDialog.getPlaceNameTextField().getText(), addPlaceDialog.getDemonymTextField().getText(),
				(TipoLugar) addPlaceDialog.getPlaceTypeComboBox().getSelectedItem()));
		repaintTable();
		addPlaceDialog.setVisible(false);
	}

	private void removePlace() {
		int id_lugar = managerLugares.findPlaceById(Integer.parseInt(removePlaceDialog.getItemCB())).getIdLugar();
		connect.deletePlace(id_lugar);
		managerLugares.setPlacesList(connect.getPlaces());
		addPlaceDialog.getSpinnerNumberModel().setMaximum(managerLugares.newPlaceId());
		addPlaceDialog.getUbicationSpinner().setModel(addPlaceDialog.getSpinnerNumberModel());
		repaintTable();
		removePlaceDialog.setVisible(false);
	}

	private void editPlace() {
		int id_lugar = managerLugares.findPlaceById(Integer.parseInt(editPlaceDialog.getItemCB())).getIdLugar();
		connect.renameplace(id_lugar, editPlaceDialog.getNewName());
		managerLugares.setPlacesList(connect.getPlaces());
		repaintTable();
		editPlaceDialog.setVisible(false);
	}

	public void repaintTable() {
		Object[] atributes = { "id_lugar", "ubicacion", "nombreLugar", "nacionalidad", "tipolugar" };
		mainFrame.getMainPanel().getDefaultTableModel().setDataVector(managerLugares.generateObjectsFromList(),
				atributes);
		mainFrame.getMainPanel().getjTable().setModel(mainFrame.getMainPanel().getDefaultTableModel());
		mainFrame.repaint();
		mainFrame.revalidate();
	}

	public static void main(String[] args) throws SQLException {
		new MainController();
	}

}
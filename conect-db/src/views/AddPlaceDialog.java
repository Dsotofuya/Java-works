package views;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controllers.Event;
import controllers.MainController;
import models.TipoLugar;

public class AddPlaceDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private SpinnerNumberModel spinnerNumberModel;
	private JSpinner UbicationSpinner;
	private JTextField PlaceNameTextField;
	private JTextField demonymTextField;
	private JComboBox<TipoLugar> placeTypeComboBox;
	
	public AddPlaceDialog(MainController controller) {
	setTitle("Nuevo Lugar");
	setSize(300, 400);
	setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	
	spinnerNumberModel = new SpinnerNumberModel();
	spinnerNumberModel.setMinimum(1);
	spinnerNumberModel.setStepSize(1);
	spinnerNumberModel.setValue(1);
	
	UbicationSpinner = new JSpinner(spinnerNumberModel);
	UbicationSpinner.setBorder(BorderFactory.createTitledBorder("id Ubicacion"));
	add(UbicationSpinner);
	
	PlaceNameTextField = new JTextField();
	PlaceNameTextField.setBorder(BorderFactory.createTitledBorder("Nombre Lugar"));
	add(PlaceNameTextField);
	
	demonymTextField = new JTextField();
	demonymTextField.setBorder(BorderFactory.createTitledBorder("Gentilicio"));
	add(demonymTextField);
	
	placeTypeComboBox = new JComboBox<TipoLugar>();
	placeTypeComboBox.addItem(TipoLugar.CI);
	placeTypeComboBox.addItem(TipoLugar.DE);
	placeTypeComboBox.addItem(TipoLugar.PA);
	placeTypeComboBox.setBorder(BorderFactory.createTitledBorder("Tipo de Lugar"));
	add(placeTypeComboBox);
	
	JButton addPlaceBtn = new JButton("Agregar Lugar");
	addPlaceBtn.addActionListener(controller);
	addPlaceBtn.setActionCommand(Event.ADD_PLACE.toString());
	add(addPlaceBtn);
	}
	
	public SpinnerNumberModel getSpinnerNumberModel() {
		return spinnerNumberModel;
	}

	public JSpinner getUbicationSpinner() {
		return UbicationSpinner;
	}

	public JTextField getPlaceNameTextField() {
		return PlaceNameTextField;
	}

	public JTextField getDemonymTextField() {
		return demonymTextField;
	}

	public JComboBox<TipoLugar> getPlaceTypeComboBox() {
		return placeTypeComboBox;
	}
}
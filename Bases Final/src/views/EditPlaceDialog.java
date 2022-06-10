package views;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import controllers.Event;
import controllers.MainController;

public class EditPlaceDialog extends JDialog {
	private static final long serialVersionUID = 8210569894645542019L;

	private JComboBox<String> placesList;
	private JTextField field;

	public EditPlaceDialog(MainController controller) {
		setTitle("Editar Lugar");
		setSize(200, 120);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		placesList = new JComboBox<>();
		placesList.setBorder(BorderFactory.createTitledBorder("Id del Lugar"));
		add(placesList);
		field = new JTextField();
		add(field);
		JButton editPlaceBtn = new JButton("Editar Lugar");
		editPlaceBtn.addActionListener(controller);
		editPlaceBtn.setActionCommand(Event.EDIT_PLACE.toString());
		add(editPlaceBtn);
	}

	public void fillBox(ArrayList<Integer> placesNames) {
		for (int placeName : placesNames) {
			placesList.addItem(String.valueOf(placeName));
		}
	}

	public String getNewName() {
		return field.getText();
	}

	public String getItemCB() {
		return (String) placesList.getSelectedItem();
	}

	public void clean() {
		field.setText("");
		placesList.removeAllItems();
	}
}

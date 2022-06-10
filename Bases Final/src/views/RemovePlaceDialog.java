package views;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import controllers.Event;
import controllers.MainController;

public class RemovePlaceDialog extends JDialog {
	private static final long serialVersionUID = -2267059414980898244L;

	private JComboBox<String> placesList;
	
	public RemovePlaceDialog(MainController controller) {
	setTitle("Borrar Lugar");
	setSize(200, 100);
	setResizable(false);
	setLocationRelativeTo(null);
	setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	placesList = new JComboBox<>();
	placesList.setBorder(BorderFactory.createTitledBorder("Id Lugar"));
	add(placesList);
	JButton deletePlaceBtn = new JButton("Borrar Lugar");
	deletePlaceBtn.addActionListener(controller);
	deletePlaceBtn.setActionCommand(Event.REMOVE_PLACE.toString());
	add(deletePlaceBtn);
	}
	
	public void fillBox(ArrayList<Integer> placesNames) {
		for (int placeName : placesNames) {
			placesList.addItem(String.valueOf(placeName));
		}
	}
	
	public void cleanComboBox() {
		placesList.removeAllItems();
	}
	
	public String getItemCB() {
		return (String) placesList.getSelectedItem();
	}
	
}

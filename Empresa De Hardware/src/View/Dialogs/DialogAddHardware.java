package View.Dialogs;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import Control.Events;
import Control.HardwareController;
import Model.Hardware;
import View.FrameHardware;

public class DialogAddHardware extends JDialog {

	private JButton addNewHardware; 
	private JTextField fieldId, fieldName, fieldDescription, fieldQuantity, fieldPrice;
	
	public DialogAddHardware(FrameHardware window, ActionListener controller) {
		setSize(500, 500);
		setLocationRelativeTo(window);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		fieldId = new JTextField();
		fieldId.setBorder(BorderFactory.createTitledBorder(window.getLenguaje().getProperty("Id")));
		add(fieldId);
		
		fieldName = new JTextField();
		fieldName.setBorder(BorderFactory.createTitledBorder(window.getLenguaje().getProperty("Name")));
		add(fieldName);
		
		fieldDescription = new JTextField();
		fieldDescription.setBorder(BorderFactory.createTitledBorder(window.getLenguaje().getProperty("Description")));
		add(fieldDescription);
		
		fieldQuantity = new JTextField();
		fieldQuantity.setBorder(BorderFactory.createTitledBorder(window.getLenguaje().getProperty("Quantity")));
		add(fieldQuantity);
		
		fieldPrice = new JTextField();
		fieldPrice.setBorder(BorderFactory.createTitledBorder(window.getLenguaje().getProperty("Price")));
		add(fieldPrice);
		
		addNewHardware = new JButton(window.getLenguaje().getProperty("Add"));
		addNewHardware.addActionListener(controller);
		addNewHardware.setActionCommand(Events.ADD.toString());
		add(addNewHardware);
	}
	
	public Hardware getHardware() {
		int quantity = Integer.parseInt(fieldQuantity.getText());
		double price = Double.parseDouble(fieldPrice.getText());
		return HardwareController.createHardware(fieldId.getText(), fieldName.getText(), fieldDescription.getText(), quantity, price);
	}
}

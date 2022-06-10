package View.Dialogs;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import Control.Events;
import Model.Hardware;
import Model.ManagerHardware;
import View.WindowFrame;

public class DialogAddHardware extends JDialog {

	private JButton addNewHardware; 
	private JTextField fieldName, fieldDescription, fieldQuantity, fieldPrice;
	
	public DialogAddHardware(WindowFrame window, ActionListener controller) {
		setSize(100, 300);
		setLocationRelativeTo(window);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		fieldName = new JTextField();
		fieldName.setBorder(BorderFactory.createTitledBorder(window.getLanguajes().getProperty("Name")));
		add(fieldName);
		
		fieldDescription = new JTextField();
		fieldDescription.setBorder(BorderFactory.createTitledBorder(window.getLanguajes().getProperty("Description")));
		add(fieldDescription);
		
		fieldQuantity = new JTextField();
		fieldQuantity.setBorder(BorderFactory.createTitledBorder(window.getLanguajes().getProperty("Quantity")));
		add(fieldQuantity);
		
		fieldPrice = new JTextField();
		fieldPrice.setBorder(BorderFactory.createTitledBorder(window.getLanguajes().getProperty("Price")));
		add(fieldPrice);
		
		addNewHardware = new JButton(window.getLanguajes().getProperty("Add"));
		addNewHardware.addActionListener(controller);
		addNewHardware.setActionCommand(Events.ADD.toString());
		add(addNewHardware);
	}

	public String getName() {
		String name = fieldName.getText();
		return name;
	}

	public String getDescription() {
		String Description = fieldDescription.getText();
		return Description;
	}
	
	public String getQuantity() {
		String quantity = fieldQuantity.getText();
		return quantity;
	}
	
	public String getPrice() {
		String price = fieldPrice.getText();
		return price;
	}
	
	public void clearDialog() {
		fieldName.setText("");
		fieldDescription.setText("");
		fieldQuantity.setText("");
		fieldPrice.setText("");
	}
}

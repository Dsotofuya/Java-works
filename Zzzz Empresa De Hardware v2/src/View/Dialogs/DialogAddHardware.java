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
	private JTextField fieldId, fieldName, fieldDescription, fieldQuantity, fieldPrice;
	
	public DialogAddHardware(WindowFrame window, ActionListener controller) {
		super(window, true);
		setSize(500, 500);
		setLocationRelativeTo(window);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		fieldId = new JTextField();
		fieldId.setBorder(BorderFactory.createTitledBorder("Id"));
		add(fieldId);
		
		fieldName = new JTextField();
		fieldName.setBorder(BorderFactory.createTitledBorder("Name"));
		add(fieldName);
		
		fieldDescription = new JTextField();
		fieldDescription.setBorder(BorderFactory.createTitledBorder("Description"));
		add(fieldDescription);
		
		fieldQuantity = new JTextField();
		fieldQuantity.setBorder(BorderFactory.createTitledBorder("Quantity"));
		add(fieldQuantity);
		
		fieldPrice = new JTextField();
		fieldPrice.setBorder(BorderFactory.createTitledBorder("Price"));
		add(fieldPrice);
		
		addNewHardware = new JButton("Add");
		addNewHardware.addActionListener(controller);
		addNewHardware.setActionCommand(Events.ADD.toString());
		add(addNewHardware);
	}
	
	public Hardware getHardware() {
		return ManagerHardware.createHardware(fieldId.getText(), fieldName.getText(), fieldDescription.getText(), fieldQuantity.getText(), fieldPrice.getText());
	}
}

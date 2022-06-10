package View.Dialogs;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import Control.Events;
import View.WindowFrame;

public class DialogDelete extends JDialog{
	
	private JTextField fieldId;
	
	public DialogDelete(WindowFrame frame, ActionListener controller) {
	
		setSize(100, 100);
		setLocationRelativeTo(frame);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		fieldId = new JTextField();
		fieldId.setBorder(BorderFactory.createTitledBorder(frame.getLanguajes().getProperty("Id")));
		add(fieldId);
		
		JButton button = new JButton(frame.getLanguajes().getProperty("Delete"));
		button.addActionListener(controller);
		button.setActionCommand(Events.DELETE.toString());
		add(button);

	}
	
	public String getId() {
		String id = fieldId.getText();
		return id;
	}
		
	public void clearId() {
		fieldId.setText("");
	}
}

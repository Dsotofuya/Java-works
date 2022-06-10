package view.add;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.Events;

public class AddDialog extends JDialog {
	private static final long serialVersionUID = -478278761977106252L;

	private static final String DIALOG_TITLE = "Create Post";
	private static final String BACKGROUND = "#466E80";
	private static final String BUTTON_BACKGROUND = "#78BBFF";
	private static final String TITLE = "Title";
	private static final String PHOTO_PATH = "PhotoPath";
	private static final String DESCRIPTION = "Description";
	private static final String PHONE = "Phone";
	private static final String ACCEPT = "Accept";
	private static final String EMPTY = "";
	
	private JTextField tittle, photoPath, phone;
	private JTextArea description;
	private JButton accept;

	public AddDialog(ActionListener control) {
		setTitle(DIALOG_TITLE);
		setSize(new Dimension(250, 350));
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5, 1));
		tittle = new JTextField();
		tittle.setBorder(BorderFactory.createTitledBorder(TITLE));
		tittle.setBackground(Color.decode(BACKGROUND));
		add(tittle);

		photoPath = new JTextField();
		photoPath.setBorder(BorderFactory.createTitledBorder(PHOTO_PATH));
		photoPath.setBackground(Color.decode(BACKGROUND));
		add(photoPath);

		description = new JTextArea();
		description.setBorder(BorderFactory.createTitledBorder(DESCRIPTION));
		description.setBackground(Color.decode(BACKGROUND));
		add(description);

		phone = new JTextField();
		phone.setBorder(BorderFactory.createTitledBorder(PHONE));
		phone.setBackground(Color.decode(BACKGROUND));
		add(phone);

		accept = new JButton(ACCEPT);
		accept.addActionListener(control);
		accept.setBackground(Color.decode(BUTTON_BACKGROUND));
		accept.setForeground(Color.white);
		accept.setActionCommand(Events.CREATE.toString());
		add(accept);
	}
	
	public void clean() {
		tittle.setText(EMPTY);
		photoPath.setText(EMPTY);
		phone.setText(EMPTY);
		description.setText(EMPTY);
	}

	public String getTittleText() {
		return tittle.getText();
	}

	public int getPhoneText() {
		return Integer.parseInt(phone.getText());
	}

	public String getDescriptionText() {
		return description.getText();
	}

	public String getphtoText() {
		return photoPath.getText();
	}
}

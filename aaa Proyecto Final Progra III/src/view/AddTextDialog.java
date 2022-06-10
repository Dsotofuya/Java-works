package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddTextDialog extends JDialog {

	private static final long serialVersionUID = 3855565004775474189L;

	private JLabel nameDialog;
	private JComboBox<Object> selectObject;
	private JTextField name, text;
	private JButton acept;
	private File file;

	public AddTextDialog(ActionListener control, String nameJDialog, String event, Object[] list) {
		setSize(300, 250);
		setTitle(nameJDialog);
		setLayout(new FlowLayout());
		nameDialog = new JLabel(nameJDialog);
		nameDialog.setHorizontalAlignment(SwingConstants.CENTER);
		nameDialog.setPreferredSize(new Dimension(200, 30));
		add(nameDialog);
		selectObject = new JComboBox<Object>();
		selectObject.setModel(new DefaultComboBoxModel<Object>(list));
		selectObject.setPreferredSize(new Dimension(200, 30));
		add(selectObject);
		name = new JTextField();
		name.setToolTipText("Input name of text");
		name.setPreferredSize(new Dimension(200, 30));
		add(name);
		text = new JTextField();
		text.setToolTipText("Input the text");
		text.setPreferredSize(new Dimension(200, 30));
		add(text);
		acept = new JButton("Acept");
		acept.addActionListener(control);
		acept.setPreferredSize(new Dimension(200, 25));
		acept.setActionCommand(event);
		add(acept);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public String getSelectedObj() {
		return (String) selectObject.getSelectedItem();
	}

	public String getNameObj() {
		return name.getText();
	}

	public String getTextPostal() {
		return text.getText();
	}

	public File getFileImage() {
		return file;
	}

	public void clearComponents() {
		text.setText("");
		file = null;
		name.setText("");
		selectObject.removeAllItems();
	}
}

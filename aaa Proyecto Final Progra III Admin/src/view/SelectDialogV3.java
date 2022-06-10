package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import control.Events;

public class SelectDialogV3 extends JDialog {

	private static final long serialVersionUID = 3855565004775474189L;

	private JLabel nameDialog;
	private JComboBox<Object> selectObject;
	private JComboBox<Object> selectImage;
	private JComboBox<Object> selectText;
	private JButton acept;

	public SelectDialogV3(ActionListener control, String nameJDialog, String event, Object[] listUser, Object[] listArchives, Object[] listPrivileges) {
		setSize(300, 250);
		setLayout(new FlowLayout());
		nameDialog = new JLabel(nameJDialog);
		nameDialog.setHorizontalAlignment(SwingConstants.CENTER);
		nameDialog.setPreferredSize(new Dimension(200, 30));
		add(nameDialog);
		selectObject = new JComboBox<Object>();
		selectObject.setModel(new DefaultComboBoxModel<Object>(listUser));
		selectObject.addActionListener(control);
		selectObject.setActionCommand(Events.POSTAL_SELECTED.toString());
		selectObject.setPreferredSize(new Dimension(200, 30));
		add(selectObject);
		selectImage = new JComboBox<Object>();
		selectImage.setModel(new DefaultComboBoxModel<Object>(listArchives));
		selectImage.setPreferredSize(new Dimension(200, 30));
		add(selectImage);
		selectText = new JComboBox<Object>();
		selectText.setModel(new DefaultComboBoxModel<Object>(listPrivileges));
		selectText.setPreferredSize(new Dimension(200, 30));
		add(selectText);
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
		
	public String getSelectedImage() {
		return (String) selectImage.getSelectedItem();
	}
		
	public String getSelectedText() {
		return (String) selectText.getSelectedItem();
	}
}

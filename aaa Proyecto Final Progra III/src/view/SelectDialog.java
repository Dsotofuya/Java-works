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

public class SelectDialog extends JDialog {

	private static final long serialVersionUID = 3855565004775474189L;

	private JLabel nameDialog;
	private JComboBox<Object> selectObject;
	private JButton acept;

	public SelectDialog(ActionListener control, String nameJDialog, String event, Object[] list) {
		setSize(250, 150);
		setLayout(new FlowLayout());
		nameDialog = new JLabel(nameJDialog);
		nameDialog.setHorizontalAlignment(SwingConstants.CENTER);
		nameDialog.setPreferredSize(new Dimension(200, 30));
		add(nameDialog);
		selectObject = new JComboBox<Object>();
		selectObject.setModel(new DefaultComboBoxModel<Object>(list));
		selectObject.setPreferredSize(new Dimension(200, 30));
		add(selectObject);
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
		
	public void clearComponents() {
		selectObject.removeAllItems();
	}
}

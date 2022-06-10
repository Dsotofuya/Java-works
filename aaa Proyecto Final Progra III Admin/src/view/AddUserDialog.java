package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddUserDialog extends JDialog {

	private static final long serialVersionUID = 3855565004775474189L;

	private JLabel nameDialog;
	private JTextField name, text;
	private JButton acept;

	public AddUserDialog(ActionListener control, String nameJDialog, String event) {
		setSize(300, 200);
		setTitle(nameJDialog);
		setLayout(new FlowLayout());
		nameDialog = new JLabel(nameJDialog);
		nameDialog.setHorizontalAlignment(SwingConstants.CENTER);
		nameDialog.setPreferredSize(new Dimension(200, 30));
		add(nameDialog);
		name = new JTextField();
		name.setToolTipText("Input name of the user");
		name.setPreferredSize(new Dimension(200, 30));
		add(name);
		text = new JTextField();
		text.setToolTipText("Input the password");
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

	public String getNameObj() {
		return name.getText();
	}

	public String getNewPassword() {
		return text.getText();
	}

	public void clearComponents() {
		text.setText("");
		name.setText("");
	}
}

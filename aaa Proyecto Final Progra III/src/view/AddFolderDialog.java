	package view;

	import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.Events;

	public class AddFolderDialog extends JDialog {

		private static final long serialVersionUID = 3855565004775474189L;

		private JLabel nameDialog;
		private JTextField name;
		private JButton acept;

		public AddFolderDialog(ActionListener control) {
			setSize(250, 200);
			setLayout(new FlowLayout());
			nameDialog = new JLabel("Add folder");
			nameDialog.setHorizontalAlignment(SwingConstants.CENTER);
			nameDialog.setPreferredSize(new Dimension(200, 30));
			add(nameDialog);
			name = new JTextField();
			name.setSize(new Dimension(120, 30));
			name.setPreferredSize(new Dimension(200, 30));
			add(name);
			acept = new JButton("Acept");
			acept.setPreferredSize(new Dimension(200, 25));
			acept.setActionCommand(Events.ADD_FOLDER.toString());
			acept.addActionListener(control);
			add(acept);
			setLocationRelativeTo(null);
			setVisible(true);
		}

		public String getNameFolder() {
			return name.getText();
		}
			
		public void clearField() {
			name.setText("");
		}
}

package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddImageDialog extends JDialog {

	private static final long serialVersionUID = 3855565004775474189L;

	private JLabel nameDialog;
	private JComboBox<Object> selectObject;
	private JTextField name, path;
	private JButton acept, showFileChooser;
	private File file;

	public AddImageDialog(ActionListener control, String nameJDialog, String event, Object[] list) {
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
		name.setToolTipText("Input name of image");
		name.setPreferredSize(new Dimension(200, 30));
		add(name);
		path = new JTextField();
		path.setToolTipText("Input path of image");
		path.setPreferredSize(new Dimension(175, 30));
		add(path);
		showFileChooser = new JButton("...");
		showFileChooser.setPreferredSize(new Dimension(50, 30));
		showFileChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter(".jpg", "jpg"));
				int seleccion = fileChooser.showOpenDialog(null);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
					path.setText(file.getAbsolutePath());
				}
			}
		});
		add(showFileChooser);
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

	public String getPathImageField() {
		return path.getText();
	}

	public File getFileImage() {
		return file;
	}

	public void clearComponents() {
		path.setText("");
		file = null;
		name.setText("");
		selectObject.removeAllItems();
	}
}

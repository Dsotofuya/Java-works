package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.Actions;

public class JDialogAddForm extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField titleTF, descriptionTF, contactNumberTF;
	private JLabel jlabelTitle, jLabelDescription, jlabelContactNumber;
	private File file;
	public JFileChooser chooser;

	public JDialogAddForm(JFrame main, ActionListener listener) {
		super(main);
		setSize(380, 680);
		setModal(true);
		setLocationRelativeTo(this);
		setTitle("Agregar publicación");
		setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setIUManager();

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(8, 1, 20, 30));
		jPanel.setBackground(Color.WHITE);
		jPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

		jlabelTitle = new JLabel("Ingrese el nombre del objeto");
		jPanel.add(jlabelTitle);

		titleTF = new JTextField();
		jPanel.add(titleTF);

		jLabelDescription = new JLabel("Haga una breve descripción del objeto");
		jPanel.add(jLabelDescription);

		descriptionTF = new JTextField();
		jPanel.add(descriptionTF);

		jlabelContactNumber = new JLabel("Ingrese el número de contacto");
		jPanel.add(jlabelContactNumber);

		contactNumberTF = new JTextField();
		jPanel.add(contactNumberTF);

		add(jPanel, BorderLayout.CENTER);

		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new FlowLayout());

		jPanel2.setBackground(Color.WHITE);

		JButton btnBack = new JButton("Atras");
		btnBack.setToolTipText("Atrás");
		btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnBack.addActionListener(listener);
		btnBack.setActionCommand(Actions.BACK_DIALOG.toString());
		jPanel2.add(btnBack);
		JButton btadd = new JButton("Agregar");
		btadd.setToolTipText("Agregar");
		btadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btadd.addActionListener(listener);
		btadd.setActionCommand(Actions.ADD_POST.toString());
		jPanel2.add(btadd);

		chooser = new JFileChooser();
		
		JButton btnFile = new JButton("Selecciona imágen"+ "");
		btnFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(getContentPane());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
					System.out.println(file.getName());
				} else {
					System.out.println("Open command cancelled by user.");
				}
			}
		});
		jPanel.add(btnFile);
		add(jPanel2, BorderLayout.SOUTH);

	}

	private void setIUManager() {
		UIManager.put("Border.background", Color.WHITE);
		UIManager.put("Label.font", ConstantsGUI.RALEWAY_FONT);
		UIManager.put("Label.foreground", Color.BLACK);
		UIManager.put("Label.cursor", new Cursor(Cursor.HAND_CURSOR));
		UIManager.put("TextField.border", new RoundedBorder(15));
		UIManager.put("Button.font", ConstantsGUI.RALEWAY_FONT);
		UIManager.put("Button.background", Color.WHITE);
		UIManager.put("Button.foreground", Color.BLACK);
	}

	public String getJlabelTitle() {
		return titleTF.getText();
	}

	public String getjLabelDescription() {
		return descriptionTF.getText();
	}

	public String getJlabelContactNumber() {
		return contactNumberTF.getText();
	}
	
	public String getFile() {
		return file.getAbsolutePath();
	}
}

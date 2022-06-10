package view;

import controller.Events;
import utilities.CustomDocumentFilter;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelWest extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel jLTitle;
	private JLabel jLInfo;
	private JLabel jLName;
	private JTextField jTFName;
	private JLabel jLTime;
	private JTextField jSTime;
	private JLabel jLSize;
	private JTextField jTFSize;
	private JButton jBSaveProcess;
	private JButton jBCleanProcessForm;
	private JButton jBDeleteProcess;
	private JTextField jTFPartitionName;

	private JLabel jLPartitionSize;
	private JTextField jTFPartitionSize;
	private JButton jBClose;
	private JButton jBMinimize;
	private JButton jBStart;
	private ActionListener actionListener;
	private GridBagConstraints constraints;

	public JPanelWest(ActionListener actionListener) {
		setOpaque(false);
		this.actionListener = actionListener;
		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		initComponents();
		this.setVisible(true);
	}

	public void initComponents() {

		jBClose = new JButton("Cerrar Ventana");
		jBClose.addActionListener(actionListener);
		jBClose.setActionCommand(Events.CLOSE.toString());
		jBClose.setPreferredSize(new Dimension(50, 15));
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.weighty = 0.3;

		jBMinimize = new JButton("Minimizar");
		jBMinimize.addActionListener(actionListener);
		jBMinimize.setActionCommand(Events.MINIMIZE.toString());
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.weighty = 0.3;

		jLTitle = new JLabel("Agregar proceso", JLabel.CENTER);
		jLTitle.setFont(new Font("Helvetiva", Font.PLAIN, 30));
		jLTitle.setPreferredSize(new Dimension(450, 100));
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.weighty = 0.3;
		this.add(jLTitle, constraints);

		jLName = new JLabel("Nombre del proceso: ");
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 0.01;
		this.add(jLName, constraints);

		jTFName = new JTextField();
		jTFName.setPreferredSize(new Dimension(200, 60));
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.weighty = 0.01;
		this.add(jTFName, constraints);

		jLTime = new JLabel("Tiempo del proceso: ");
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.weighty = 0.1;
		this.add(jLTime, constraints);

		jSTime = new JTextField();
		jSTime.setPreferredSize(new Dimension(200, 60));
		((AbstractDocument) jSTime.getDocument()).setDocumentFilter(new CustomDocumentFilter());
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.weighty = 0.1;
		this.add(jSTime, constraints);

		jLSize = new JLabel("Tamaño");
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.weighty = 0.1;
		this.add(jLSize, constraints);

		jTFSize = new JTextField();
		jTFSize.setPreferredSize(new Dimension(200, 60));
		((AbstractDocument) jTFSize.getDocument()).setDocumentFilter(new CustomDocumentFilter());
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 2;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.weighty = 1;
		this.add(jTFSize, constraints);
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.weighty = 1;
		constraints.gridx = 2;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.weighty = 1;

		jBSaveProcess = new JButton("Agregar Proceso");
		jBSaveProcess.addActionListener(actionListener);
		jBSaveProcess.setActionCommand(Events.ADD_PROCESS.toString());
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.gridx = 1;
		constraints.gridy = 7;
		constraints.gridwidth = 1;
		constraints.weighty = 0.1;
		this.add(jBSaveProcess, constraints);

		jBCleanProcessForm = new JButton("Limpiar Formulario");
		jBCleanProcessForm.addActionListener(this);
		jBCleanProcessForm.setActionCommand(Events.CLEAR_PROCESS_FORM.toString());
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.gridx = 2;
		constraints.gridy = 7;
		constraints.gridwidth = 1;
		constraints.weighty = 0.1;
		this.add(jBCleanProcessForm, constraints);

		jBDeleteProcess = new JButton("Eliminar proceso");
		jBDeleteProcess.addActionListener(actionListener);
		jBDeleteProcess.setActionCommand(Events.DELETE_PROCESS.toString());
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 1;
		constraints.gridy = 8;
		constraints.gridwidth = 2;
		constraints.weighty = 0.1;
		this.add(jBDeleteProcess, constraints);

		jLPartitionSize = new JLabel("Tamaño memoria Principal");
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.gridx = 1;
		constraints.gridy = 11;
		constraints.gridwidth = 1;
		constraints.weighty = 1;
		this.add(jLPartitionSize, constraints);

		jTFPartitionSize = new JTextField();
		jTFPartitionSize.setPreferredSize(new Dimension(200, 60));
		((AbstractDocument) jTFPartitionSize.getDocument()).setDocumentFilter(new CustomDocumentFilter());
		constraints.gridx = 2;
		constraints.gridy = 11;
		constraints.gridwidth = 1;
		constraints.weighty = 1;
		this.add(jTFPartitionSize, constraints);

		jLInfo = new JLabel("Desarrollado por: Daniel, Jhonatan, Jhon");
		jLInfo.setForeground(Color.black);
		constraints.gridx = 1;
		constraints.gridy = 16;
		constraints.gridwidth = 2;
		constraints.weighty = 0.3;
		this.add(jLInfo, constraints);

		jBStart = new JButton("Realizar Simulación");
		jBStart.addActionListener(actionListener);
		jBStart.setActionCommand(Events.START.toString());
		jBStart.setBorder(BorderFactory.createEmptyBorder());
		constraints.insets = new Insets(10, 40, 10, 40);
		constraints.gridx = 1;
		constraints.gridy = 15;
		constraints.gridwidth = 2;
		constraints.weighty = 1;
		this.add(jBStart, constraints);
	}

	public void cleanProcessForm() {
		jTFName.setText("");

		((AbstractDocument) jSTime.getDocument()).setDocumentFilter(null);
		jSTime.setText("");
		((AbstractDocument) jSTime.getDocument()).setDocumentFilter(new CustomDocumentFilter());

		((AbstractDocument) jTFSize.getDocument()).setDocumentFilter(null);
		jTFSize.setText("");
		((AbstractDocument) jTFSize.getDocument()).setDocumentFilter(new CustomDocumentFilter());
	}

	public void cleanPartitionForm() {
		jTFPartitionName.setText("");

		((AbstractDocument) jTFPartitionSize.getDocument()).setDocumentFilter(null);
		jTFPartitionSize.setText("");
		((AbstractDocument) jTFPartitionSize.getDocument()).setDocumentFilter(new CustomDocumentFilter());
	}

	public String getNameProcess() {
		return jTFName.getText();
	}

	public int getTimeProcess() {
		if (jSTime.getText().equals("")) {
			return 0;
		}
		int value = Integer.parseInt(jSTime.getText());
		((AbstractDocument) jSTime.getDocument()).setDocumentFilter(null);
		return value;
	}

	public int getSizeProcess() {
		if (jTFSize.getText().equals("")) {
			return 0;
		}
		int value = Integer.parseInt(jTFSize.getText());
		((AbstractDocument) jTFSize.getDocument()).setDocumentFilter(null);
		return value;
	}

	public String getPartitionName() {
		return jTFPartitionName.getText();
	}

	public int getPartitionSize() {
		if (jTFPartitionSize.getText().equals("")) {
			return 0;
		}
		int value = Integer.parseInt(jTFPartitionSize.getText());
		((AbstractDocument) jTFPartitionSize.getDocument()).setDocumentFilter(null);
		return value;
	}

	public JButton createButton() {
		JButton button = new JButton();
		button.setEnabled(false);
		button.setBorder(BorderFactory.createEmptyBorder());
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case CLEAR_PROCESS_FORM:
			cleanProcessForm();
			break;
		case CLEAR_PARTITION_FORM:
			cleanPartitionForm();
			break;
		default:
			break;
		}
	}
}

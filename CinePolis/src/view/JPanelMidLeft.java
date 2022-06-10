package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants;
import model.Person;;

public class JPanelMidLeft extends JPanel {

	public static final String NAME = "Nombre";
	public static final String LASTNAME = "Apellido";
	public static final String NUMDOC = "Numero de documento";
	public static final String DOCTYPE = "Tipo de documento";
	public static final String GENDER = "Genero";
	public static final String BORNDAY = "Fecha de nacimiento";

	private Constants constants;
	private Person person;
	private JLabel label1, label2, label3, label4, label5, label6;
	private JTextField textName, textLastName, textDocument, textDate;
	private JComboBox textType, textGender;

	public JPanelMidLeft(JframeMain jframeMain) {
		person = new Person();
		setLayout(new GridLayout(6, 2));
		setBackground(Color.decode("#0b5ba1"));
		constants = new Constants();
		setVisible(true);
		init();
	}

	public void init() {
		label1 = new JLabel(NAME);
		label1.setForeground(Color.white);
		add(label1);
		textName = new JTextField("");
		add(textName);

		label2 = new JLabel(LASTNAME);
		label2.setForeground(Color.white);
		add(label2);
		textLastName = new JTextField("");
		add(textLastName);

		label3 = new JLabel(NUMDOC);
		label3.setForeground(Color.white);
		add(label3);
		textDocument = new JTextField("");
		add(textDocument);

		label4 = new JLabel(DOCTYPE);
		label4.setForeground(Color.white);
		add(label4);
		textType = new JComboBox(constants.DOC);
		add(textType);

		label5 = new JLabel(GENDER);
		label5.setForeground(Color.white);
		this.add(label5);
		textGender = new JComboBox(constants.GENDER);
		this.add(textGender);

		label6 = new JLabel(BORNDAY);
		label6.setForeground(Color.white);
		this.add(label6);
		textDate = new JTextField("DD/MM/YYYY");
		this.add(textDate);
	}

	public Person makePerson() {
		String name = textName.getText().toString();
		String lastname = textLastName.getText();
		String doc = textDocument.getText();
		String type = textType.getSelectedItem().toString();
		String gender = textGender.getSelectedItem().toString();
		String date = textDate.getText();
		person = new Person(name, lastname, doc, type, gender, date);
		return person;
	}

}
